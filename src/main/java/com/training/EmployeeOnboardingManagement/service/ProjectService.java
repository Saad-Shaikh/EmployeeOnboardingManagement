package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.entity.ProjectEntity;
import com.training.EmployeeOnboardingManagement.entity.TaskEntity;

import java.util.List;

public interface ProjectService {
//    ProjectEntity getEmployeeProject(Integer id);
//    ProjectEntity addEmployeeProject(Integer id, ProjectEntity project);
//    ProjectEntity updateEmployeeProject(Integer id, ProjectEntity newProject);
    List<TaskEntity> getTasksForProject(Integer id);
}
