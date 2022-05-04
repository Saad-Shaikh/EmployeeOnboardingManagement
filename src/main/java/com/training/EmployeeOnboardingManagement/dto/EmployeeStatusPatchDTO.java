package com.training.EmployeeOnboardingManagement.dto;

import com.training.EmployeeOnboardingManagement.enums.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
public class EmployeeStatusPatchDTO {
    @NotNull()
    private Integer id;

    @NotNull()
    private EmployeeStatus status;
}
