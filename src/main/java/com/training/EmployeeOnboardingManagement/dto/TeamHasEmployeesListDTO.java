package com.training.EmployeeOnboardingManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class TeamHasEmployeesListDTO {
    private Integer id;
    private EmployeeListDTO employeeListDTO;
    private LocalDate startDate;
    private LocalDate endDate;
}