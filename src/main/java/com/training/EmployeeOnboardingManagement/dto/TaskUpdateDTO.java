package com.training.EmployeeOnboardingManagement.dto;

import com.training.EmployeeOnboardingManagement.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class TaskUpdateDTO {
    @NotBlank(message = "Task cannot be blank")
    private String task;

    @NotNull(message = "Task type cannot be null")
    private TaskType taskType;
}
