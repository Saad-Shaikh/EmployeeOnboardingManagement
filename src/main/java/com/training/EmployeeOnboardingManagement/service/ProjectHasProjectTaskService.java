package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.entity.ProjectEntity;
import com.training.EmployeeOnboardingManagement.entity.ProjectHasProjectTaskEntity;
import com.training.EmployeeOnboardingManagement.entity.TaskEntity;

import java.util.List;

public interface ProjectHasProjectTaskService {
    void addAllTasksToProject(ProjectEntity savedProject, List<TaskEntity> projectTasks);

    List<ProjectHasProjectTaskEntity> getTasksForProject(Integer id);
}
