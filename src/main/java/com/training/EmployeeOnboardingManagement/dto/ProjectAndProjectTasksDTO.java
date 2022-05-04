package com.training.EmployeeOnboardingManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ProjectAndProjectTasksDTO {
    private Integer id;
    private String name;
    private String description;
    private String repoUrl;
    private List<ProjectTaskDetailDTO> projectTasks;
}
