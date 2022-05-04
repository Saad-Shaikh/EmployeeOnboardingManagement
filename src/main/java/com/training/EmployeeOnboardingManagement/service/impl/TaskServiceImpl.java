package com.training.EmployeeOnboardingManagement.service.impl;

import com.training.EmployeeOnboardingManagement.dao.TaskRepository;
import com.training.EmployeeOnboardingManagement.dto.TaskCreateDTO;
import com.training.EmployeeOnboardingManagement.dto.TaskDetailDTO;
import com.training.EmployeeOnboardingManagement.dto.TaskUpdateDTO;
import com.training.EmployeeOnboardingManagement.entity.TaskEntity;
import com.training.EmployeeOnboardingManagement.enums.ErrorMessage;
import com.training.EmployeeOnboardingManagement.enums.TaskType;
import com.training.EmployeeOnboardingManagement.exception.ErrorMessagePayload;
import com.training.EmployeeOnboardingManagement.exception.NotFoundException;
import com.training.EmployeeOnboardingManagement.mapper.TaskMapper;
import com.training.EmployeeOnboardingManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<TaskEntity> findByTaskType(TaskType taskType) {
        return taskRepository.findByTaskType(taskType);
    }

    @Override
    public List<TaskDetailDTO> getAllTasks() {
        return taskMapper.mapEntityListToDetailDTOList(taskRepository.findAll());
    }

    @Override
    public TaskDetailDTO createTask(TaskCreateDTO taskCreateDTO) {
        TaskEntity task = taskMapper.mapCreateDTOToEntity(taskCreateDTO);
        return taskMapper.mapEntityToDetailDTO(taskRepository.save(task));
    }

    @Override
    public TaskDetailDTO updateTask(Integer id, TaskUpdateDTO taskUpdateDTO) {
        TaskEntity task = getById(id);
        taskMapper.mapUpdateDTOToEntity(taskUpdateDTO, task);
        return taskMapper.mapEntityToDetailDTO(task);
    }

    @Override
    public void deleteTask(Integer id) {
        TaskEntity task = getById(id);
        taskRepository.delete(task);
    }

    private TaskEntity getById(Integer id) {
        return taskRepository.findById(id).orElseThrow(
                () -> new NotFoundException(new ErrorMessagePayload(HttpStatus.NOT_FOUND, ErrorMessage.NOT_FOUND, "Task with id " + id + " does not exist"))
        );
    }
}
