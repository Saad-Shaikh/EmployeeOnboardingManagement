package com.training.EmployeeOnboardingManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnboardingTaskAssignDTO {
    @NotNull()
    private List<TaskDetailDTO> taskList;
}
