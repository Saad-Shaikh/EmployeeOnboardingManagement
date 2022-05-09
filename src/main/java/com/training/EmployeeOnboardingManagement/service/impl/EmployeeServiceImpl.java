package com.training.EmployeeOnboardingManagement.service.impl;

import com.querydsl.core.BooleanBuilder;
import com.training.EmployeeOnboardingManagement.dao.EmployeeRepository;
import com.training.EmployeeOnboardingManagement.dto.*;
import com.training.EmployeeOnboardingManagement.entity.EmployeeEntity;
import com.training.EmployeeOnboardingManagement.entity.EmployeeHasMentorsEntity;
import com.training.EmployeeOnboardingManagement.entity.ProjectEntity;
import com.training.EmployeeOnboardingManagement.entity.QEmployeeEntity;
import com.training.EmployeeOnboardingManagement.enums.EmployeeStatus;
import com.training.EmployeeOnboardingManagement.enums.ErrorMessage;
import com.training.EmployeeOnboardingManagement.exception.ErrorMessagePayload;
import com.training.EmployeeOnboardingManagement.exception.NotFoundException;
import com.training.EmployeeOnboardingManagement.mapper.EmployeeMapper;
import com.training.EmployeeOnboardingManagement.service.EmployeeMentorsService;
import com.training.EmployeeOnboardingManagement.service.EmployeeService;
import com.training.EmployeeOnboardingManagement.validator.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeValidator employeeValidator;
    @Autowired
    private EmployeeMentorsService employeeMentorsService;

    @Override
    public List<EmployeeListDTO> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        List<EmployeeListDTO> employeeDTOs = employeeMapper.mapEntityListToListDTOList(employees);
        return employeeDTOs;
    }

    @Override
    public EmployeeDetailDTO createEmployee(EmployeeCreateDTO employee) {
        employeeValidator.validate(employee);
        EmployeeEntity employeeEntity = employeeMapper.mapCreateDTOToEntity(employee);
        employee.getMentoredBy().forEach(mentor -> employeeEntity.getMentoredBy().add(getById(mentor.getId())));
        employeeRepository.save(employeeEntity);
        return getEmployeeById(employeeEntity.getId());
    }

    @Override
    public EmployeeDetailDTO getEmployeeById(Integer id) {
        EmployeeEntity employee = getById(id);
        EmployeeDetailDTO employeeDetailDTO =  employeeMapper.mapEntityToDetailDTO(employee);
        employeeDetailDTO.setMentors(getEmployeeMentors(id));
        return employeeDetailDTO;
    }

    @Override
    public EmployeeDetailDTO updateEmployeeById(Integer id, EmployeeUpdateDTO newEmployee) {
        employeeValidator.validate(newEmployee);
        EmployeeEntity employee = getById(id);
        employeeMapper.mapUpdateDTOToEntity(newEmployee, employee);
        return employeeMapper.mapEntityToDetailDTO(employee);
    }

    @Override
    public EmployeeDetailDTO updateEmployeeStatusById(Integer id, EmployeeStatusPatchDTO employeeStatusPatchDTO) {
        EmployeeEntity employee = getById(id);
        if (validateEmployeeStatus(employee.getStatus(), employeeStatusPatchDTO.getStatus())) {
            employeeMapper.mapStatusPatchDTOToEntity(employeeStatusPatchDTO, employee);
        }
        return employeeMapper.mapEntityToDetailDTO(employee);
    }

    @Override
    public List<EmployeeDetailDTO> searchEmployeesByFields(EmployeeSearchDTO employeeSearchDTO) {
        BooleanBuilder builder = constructBooleanBuilderForSearch(employeeSearchDTO);
        List<EmployeeEntity> employees = (List<EmployeeEntity>) employeeRepository.findAll(builder);
        return employeeMapper.mapEntityListToDetailDTOList(employees);
    }

    @Override
    public boolean validateEmployeeStatus(EmployeeStatus status, EmployeeStatus newStatus) {
        return !status.equals(newStatus);
    }

    @Override
    public EmployeeEntity addProjectForEmployee(Integer id, ProjectEntity project) {
        EmployeeEntity employee = getById(id);
        employee.setProject(project);
        return employee;
    }

    @Override
    public EmployeeEntity getById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new NotFoundException(new ErrorMessagePayload(HttpStatus.NOT_FOUND, ErrorMessage.NOT_FOUND, "Employee with id " + id + " does not exist!"))
        );
    }

    private Set<EmployeeListDTO> getEmployeeMentors(Integer id) {
        List<EmployeeHasMentorsEntity> employeeHasMentors = employeeMentorsService.findAllByEmployeeId(id);
        Set<EmployeeListDTO> mentors = employeeHasMentors.stream().map((employeeHasMentor) -> {
            return employeeMapper.mapEntityToListDTO(getById(employeeHasMentor.getMentorId()));
        }).collect(Collectors.toSet());
        return mentors;
    }

    private BooleanBuilder constructBooleanBuilderForSearch(EmployeeSearchDTO employeeSearchDTO) {
        BooleanBuilder builder = new BooleanBuilder();
        QEmployeeEntity qEmployee = QEmployeeEntity.employeeEntity;

        if (employeeSearchDTO.getName() != null && !employeeSearchDTO.getName().isEmpty()) {
            builder.and(qEmployee.name.containsIgnoreCase(employeeSearchDTO.getName()));
        }
        if (employeeSearchDTO.getAddress() != null && !employeeSearchDTO.getAddress().isEmpty()) {
            builder.and(qEmployee.address.containsIgnoreCase(employeeSearchDTO.getAddress()));
        }
        if (employeeSearchDTO.getPhone() != null && !employeeSearchDTO.getPhone().isEmpty()) {
            builder.and(qEmployee.phone.contains(employeeSearchDTO.getPhone()));
        }
        return builder;
    }
}
