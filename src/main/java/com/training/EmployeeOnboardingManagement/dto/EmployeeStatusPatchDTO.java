package com.training.EmployeeOnboardingManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmployeeStatusPatchDTO {
    private Integer id;
    private String status;
}
