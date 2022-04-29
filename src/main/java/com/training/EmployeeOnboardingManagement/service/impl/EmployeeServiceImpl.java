package com.training.EmployeeOnboardingManagement.service.impl;

import com.training.EmployeeOnboardingManagement.dao.EmployeeRepository;
import com.training.EmployeeOnboardingManagement.dto.CreateEmployeeDTO;
import com.training.EmployeeOnboardingManagement.dto.DetailedEmployeeDTO;
import com.training.EmployeeOnboardingManagement.dto.EmployeeStatusPatchDTO;
import com.training.EmployeeOnboardingManagement.dto.UpdateEmployeeDTO;
import com.training.EmployeeOnboardingManagement.entity.*;
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

    private EmployeeEntity getEmployeeEntityById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new NotFoundException(new ErrorMessagePayload(HttpStatus.NOT_FOUND, ErrorMessage.NOT_FOUND, "Employee with id " + id + " does not exist!"))
        );
    }

    @Override
    public List<DetailedEmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        List<DetailedEmployeeDTO> employeeDTOs = employeeMapper.mapDetailedDTOListToEntityList(employees);
        return employeeDTOs;
    }

    @Override
    public DetailedEmployeeDTO createEmployee(CreateEmployeeDTO employee) {
        EmployeeEntity employeeEntity = employeeMapper.mapCreateDTOToEntity(employee);
        employeeValidator.validateEmployee(employeeEntity);
        return employeeMapper.mapEntityToDetailedDTO(employeeRepository.save(employeeEntity));
    }

    @Override
    public DetailedEmployeeDTO getEmployeeById(Integer id) {
        EmployeeEntity employee =  getEmployeeEntityById(id);
        return employeeMapper.mapEntityToDetailedDTO(employee);
    }

    @Override
    public DetailedEmployeeDTO updateEmployeeById(Integer id, UpdateEmployeeDTO newEmployee) {
        EmployeeEntity employee = getEmployeeEntityById(id);
        employeeMapper.mapUpdateDTOToEntity(newEmployee, employee);
        return employeeMapper.mapEntityToDetailedDTO(employee);
    }

    @Override
    public DetailedEmployeeDTO updateEmployeeStatusById(Integer id, EmployeeStatusPatchDTO employeeStatusPatchDTO) {
        EmployeeEntity employee = getEmployeeEntityById(id);
        if (!employee.getStatus().equals(employeeStatusPatchDTO.getStatus())) {
            employeeMapper.mapStatusPatchDTOToEntity(employeeStatusPatchDTO, employee);
        }
        return employeeMapper.mapEntityToDetailedDTO(employee);
    }
}
