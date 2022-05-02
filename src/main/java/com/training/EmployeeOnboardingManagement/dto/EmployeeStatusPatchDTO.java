package com.training.EmployeeOnboardingManagement.dto;

import com.training.EmployeeOnboardingManagement.enums.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
public class EmployeeStatusPatchDTO {
    @NotNull(message = "ID cannot be null")
    private Integer id;

    @NotNull(message = "Status cannot be null")
    private EmployeeStatus status;
}
