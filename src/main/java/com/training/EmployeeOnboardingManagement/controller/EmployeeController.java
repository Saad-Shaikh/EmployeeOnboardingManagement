package com.training.EmployeeOnboardingManagement.controller;

import com.training.EmployeeOnboardingManagement.dto.*;
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
    public List<EmployeeDetailDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDetailDTO createEmployee(@RequestBody EmployeeCreateDTO employeeDTO) {
        return employeeService.createEmployee(employeeDTO);
    }

    @GetMapping(path = "{id}")
    public EmployeeDetailDTO getEmployeeById(@PathVariable("id") Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping(path = "{id}")
    public EmployeeDetailDTO updateEmployeeById(@PathVariable("id") Integer id, @RequestBody EmployeeUpdateDTO employeeDTO) {
        return employeeService.updateEmployeeById(id, employeeDTO);
    }

    @PatchMapping(path = "{id}")
    public EmployeeDetailDTO updateEmployeeStatusById(@PathVariable("id") Integer id, @RequestBody EmployeeStatusPatchDTO employeeStatusPatchDTO) {
        return employeeService.updateEmployeeStatusById(id, employeeStatusPatchDTO);
    }

    @GetMapping(path = "search")
    public List<EmployeeDetailDTO> searchEmployeesByFields(@RequestBody EmployeeSearchDTO employeeSearchDTO) {
        return employeeService.searchEmployeesByFields(employeeSearchDTO);
    }
}
