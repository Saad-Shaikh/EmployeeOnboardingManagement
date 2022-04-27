package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.dao.ProjectRepository;
import com.training.EmployeeOnboardingManagement.entity.ProjectEntity;
import com.training.EmployeeOnboardingManagement.entity.ProjectHasProjectTaskEntity;
import com.training.EmployeeOnboardingManagement.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectHasProjectTaskService projectHasProjectTaskService;

    @Override
    public List<TaskEntity> getTasksForProject(Integer id) {
        List<ProjectHasProjectTaskEntity> projectHasProjectTaskList = projectHasProjectTaskService.getTasksForProject(id);

    }
}
