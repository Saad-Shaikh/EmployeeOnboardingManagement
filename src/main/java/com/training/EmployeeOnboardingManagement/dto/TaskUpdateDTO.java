package com.training.EmployeeOnboardingManagement.dto;

import com.training.EmployeeOnboardingManagement.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class TaskUpdateDTO {
    @NotNull()
    private String task;

    @NotNull()
    private TaskType taskType;
}
