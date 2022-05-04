package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.dto.*;
import com.training.EmployeeOnboardingManagement.entity.EmployeeEntity;
import com.training.EmployeeOnboardingManagement.entity.ProjectEntity;
import com.training.EmployeeOnboardingManagement.enums.EmployeeStatus;

import java.util.List;

public interface EmployeeService {
    EmployeeEntity getById(Integer id);
    List<EmployeeDetailDTO> getAllEmployees();
    EmployeeDetailDTO createEmployee(EmployeeCreateDTO employee);
    EmployeeDetailDTO getEmployeeById(Integer id);
    EmployeeDetailDTO updateEmployeeById(Integer id, EmployeeUpdateDTO newEmployee);
    EmployeeDetailDTO updateEmployeeStatusById(Integer id, EmployeeStatusPatchDTO employeeStatusPatchDTO);
    List<EmployeeDetailDTO> searchEmployeesByFields(EmployeeSearchDTO employeeSearchDTO);
    boolean validateEmployeeStatus(EmployeeStatus status, EmployeeStatus newStatus);
    EmployeeEntity addProjectForEmployee(Integer id, ProjectEntity project);
}
