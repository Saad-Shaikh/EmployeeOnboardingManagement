package com.training.EmployeeOnboardingManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ProjectUpdateDTO {
    @NotNull()
    private String name;

    @NotNull()
    private String description;
}
