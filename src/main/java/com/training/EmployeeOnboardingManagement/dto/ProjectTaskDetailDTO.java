package com.training.EmployeeOnboardingManagement.dto;

import com.training.EmployeeOnboardingManagement.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class ProjectTaskDetailDTO {
    private Integer id;
    private TaskDetailDTO task;
    private String remarks;
    private LocalDate startDate;
    private LocalDate endDate;
    private String links;
    private TaskStatus status;
}
