package com.training.EmployeeOnboardingManagement.dto;

import com.training.EmployeeOnboardingManagement.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ProjectTaskUpdateDTO {
    @NotNull()
    private String remarks;

    @NotNull()
    private LocalDate startDate;

    @NotNull()
    private LocalDate endDate;

    @NotNull()
    private String links;

    @NotNull()
    private TaskStatus status;
}
