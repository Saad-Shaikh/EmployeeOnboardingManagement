package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.dto.TaskCreateDTO;
import com.training.EmployeeOnboardingManagement.dto.TaskDetailDTO;
import com.training.EmployeeOnboardingManagement.dto.TaskUpdateDTO;
import com.training.EmployeeOnboardingManagement.entity.TaskEntity;
import com.training.EmployeeOnboardingManagement.enums.TaskType;

import java.util.List;

public interface TaskService {
    List<TaskEntity> findByTaskType(TaskType taskType);

    List<TaskDetailDTO> getAllTasks();

    TaskDetailDTO createTask(TaskCreateDTO taskCreateDTO);

    TaskDetailDTO updateTask(Integer id, TaskUpdateDTO taskUpdateDTO);

    void deleteTask(Integer id);
}
