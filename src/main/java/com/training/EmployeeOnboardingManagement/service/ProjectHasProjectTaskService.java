package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.dto.ProjectTaskUpdateDTO;
import com.training.EmployeeOnboardingManagement.entity.ProjectEntity;
import com.training.EmployeeOnboardingManagement.entity.ProjectHasProjectTaskEntity;
import com.training.EmployeeOnboardingManagement.entity.TaskEntity;

import java.util.List;

public interface ProjectHasProjectTaskService {
    List<ProjectHasProjectTaskEntity> addAllProjectTasksToProject(ProjectEntity savedProject);

    List<ProjectHasProjectTaskEntity> getTasksForProject(Integer id);

    void updateProjectTask(Integer projectTaskId, ProjectTaskUpdateDTO projectTaskUpdateDTO);
}
