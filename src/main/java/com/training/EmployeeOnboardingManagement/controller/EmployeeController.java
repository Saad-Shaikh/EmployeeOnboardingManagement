package com.training.EmployeeOnboardingManagement.controller;

import com.training.EmployeeOnboardingManagement.dto.CreateEmployeeDTO;
import com.training.EmployeeOnboardingManagement.dto.DetailedEmployeeDTO;
import com.training.EmployeeOnboardingManagement.dto.EmployeeStatusPatchDTO;
import com.training.EmployeeOnboardingManagement.dto.UpdateEmployeeDTO;
import com.training.EmployeeOnboardingManagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<DetailedEmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public DetailedEmployeeDTO createEmployee(@RequestBody CreateEmployeeDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @GetMapping(path = "{id}")
    public DetailedEmployeeDTO getEmployeeById(@PathVariable("id") Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping(path = "{id}")
    public DetailedEmployeeDTO updateEmployeeById(@PathVariable("id") Integer id, @RequestBody UpdateEmployeeDTO employeeDTO) {
        return employeeService.updateEmployeeById(id, employeeDTO);
    }

    @PatchMapping(path = "{id}")
    public DetailedEmployeeDTO updateEmployeeStatusById(@PathVariable("id") Integer id, @RequestBody EmployeeStatusPatchDTO employeeStatusPatchDTO) {
        return employeeService.updateEmployeeStatusById(id, employeeStatusPatchDTO);
    }
}
