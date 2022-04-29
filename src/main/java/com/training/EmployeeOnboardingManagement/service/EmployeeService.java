package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.dto.CreateEmployeeDTO;
import com.training.EmployeeOnboardingManagement.dto.DetailedEmployeeDTO;
import com.training.EmployeeOnboardingManagement.dto.EmployeeStatusPatchDTO;
import com.training.EmployeeOnboardingManagement.dto.UpdateEmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<DetailedEmployeeDTO> getAllEmployees();
    DetailedEmployeeDTO createEmployee(CreateEmployeeDTO employee);
    DetailedEmployeeDTO getEmployeeById(Integer id);
    DetailedEmployeeDTO updateEmployeeById(Integer id, UpdateEmployeeDTO newEmployee);
    DetailedEmployeeDTO updateEmployeeStatusById(Integer id, EmployeeStatusPatchDTO employeeStatusPatchDTO);
}
