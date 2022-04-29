package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.dto.*;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDetailDTO> getAllEmployees();
    EmployeeDetailDTO createEmployee(EmployeeCreateDTO employee);
    EmployeeDetailDTO getEmployeeById(Integer id);
    EmployeeDetailDTO updateEmployeeById(Integer id, EmployeeUpdateDTO newEmployee);
    EmployeeDetailDTO updateEmployeeStatusById(Integer id, EmployeeStatusPatchDTO employeeStatusPatchDTO);
    List<EmployeeDetailDTO> searchEmployeesByFields(EmployeeSearchDTO employeeSearchDTO);
}
