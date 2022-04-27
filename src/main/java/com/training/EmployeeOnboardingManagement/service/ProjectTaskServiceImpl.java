package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.dao.ProjectTaskRepository;
import com.training.EmployeeOnboardingManagement.entity.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectTaskServiceImpl implements ProjectTaskService {
    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    @Override
    public List<TaskEntity> getProjectTasks() {
        return projectTaskRepository.findAll().stream().filter(
                task -> task.getTaskType().equals(TaskEntity.taskTypes.PROJECT)
        ).collect(Collectors.toList());
    }
}
