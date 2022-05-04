package com.training.EmployeeOnboardingManagement.service.impl;

import com.querydsl.core.BooleanBuilder;
import com.training.EmployeeOnboardingManagement.dao.EmployeeRepository;
import com.training.EmployeeOnboardingManagement.dto.*;
import com.training.EmployeeOnboardingManagement.entity.*;
import com.training.EmployeeOnboardingManagement.enums.EmployeeStatus;
import com.training.EmployeeOnboardingManagement.enums.ErrorMessage;
import com.training.EmployeeOnboardingManagement.exception.ErrorMessagePayload;
import com.training.EmployeeOnboardingManagement.exception.NotFoundException;
import com.training.EmployeeOnboardingManagement.mapper.EmployeeMapper;
import com.training.EmployeeOnboardingManagement.service.EmployeeService;
import com.training.EmployeeOnboardingManagement.validator.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private EmployeeValidator employeeValidator;
    private QEmployeeEntity qEmployee = QEmployeeEntity.employeeEntity;

    @Override
    public List<EmployeeDetailDTO> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        List<EmployeeDetailDTO> employeeDTOs = employeeMapper.mapEntityListToDetailDTOList(employees);
        return employeeDTOs;
    }

    @Override
    public EmployeeDetailDTO createEmployee(EmployeeCreateDTO employee) {
        employeeValidator.validate(employee);
        EmployeeEntity employeeEntity = employeeMapper.mapCreateDTOToEntity(employee);
        return employeeMapper.mapEntityToDetailDTO(employeeRepository.save(employeeEntity));
    }

    @Override
    public EmployeeDetailDTO getEmployeeById(Integer id) {
        EmployeeEntity employee =  getById(id);
        return employeeMapper.mapEntityToDetailDTO(employee);
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

    private BooleanBuilder constructBooleanBuilderForSearch(EmployeeSearchDTO employeeSearchDTO) {
        BooleanBuilder builder = new BooleanBuilder();
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
