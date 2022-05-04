package com.training.EmployeeOnboardingManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class ProjectCreateDTO {
    @NotBlank(message = "Project name cannot be blank")
    private String name;

    @NotBlank(message = "Description cannot be blank")
    @Size(min = 10, max = 100)
    private String description;

    @NotBlank(message = "Repository URL cannot be blank")
    private String repoUrl;
}
