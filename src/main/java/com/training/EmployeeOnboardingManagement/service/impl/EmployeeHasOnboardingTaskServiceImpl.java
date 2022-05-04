package com.training.EmployeeOnboardingManagement.service.impl;

import com.training.EmployeeOnboardingManagement.dao.EmployeeHasOnboardingTaskRepository;
import com.training.EmployeeOnboardingManagement.dto.OnboardingTaskAssignDTO;
import com.training.EmployeeOnboardingManagement.dto.OnboardingTaskDetailDTO;
import com.training.EmployeeOnboardingManagement.dto.OnboardingTaskUpdateDTO;
import com.training.EmployeeOnboardingManagement.entity.EmployeeEntity;
import com.training.EmployeeOnboardingManagement.entity.EmployeeHasOnboardingTaskEntity;
import com.training.EmployeeOnboardingManagement.entity.TaskEntity;
import com.training.EmployeeOnboardingManagement.enums.ErrorMessage;
import com.training.EmployeeOnboardingManagement.enums.TaskStatus;
import com.training.EmployeeOnboardingManagement.exception.ErrorMessagePayload;
import com.training.EmployeeOnboardingManagement.exception.NotFoundException;
import com.training.EmployeeOnboardingManagement.mapper.EmployeeHasOnboardingTaskMapper;
import com.training.EmployeeOnboardingManagement.mapper.TaskMapper;
import com.training.EmployeeOnboardingManagement.service.EmployeeHasOnboardingTaskService;
import com.training.EmployeeOnboardingManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeHasOnboardingTaskServiceImpl implements EmployeeHasOnboardingTaskService {
    @Autowired
    private EmployeeHasOnboardingTaskRepository employeeHasOnboardingTaskRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeHasOnboardingTaskMapper employeeHasOnboardingTaskMapper;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<OnboardingTaskDetailDTO> getEmployeeOnboardingTasks(Integer id) {
        return employeeHasOnboardingTaskMapper.mapEntityListToDetailDTOList(employeeHasOnboardingTaskRepository.findByEmployeeId(id));
    }

    @Override
    public List<OnboardingTaskDetailDTO> addEmployeeOnboardingTasks(Integer id, OnboardingTaskAssignDTO onboardingTaskAssignDTO) {
        EmployeeEntity employee = employeeService.getById(id);
        List<TaskEntity> onboardingTasks = taskMapper.mapDetailDTOListToEntityList(onboardingTaskAssignDTO.getTaskList());
        List<EmployeeHasOnboardingTaskEntity> employeeHasOnboardingTaskList = new ArrayList<>();
        for (TaskEntity obTask : onboardingTasks) {
            EmployeeHasOnboardingTaskEntity employeeHasOnboardingTask = new EmployeeHasOnboardingTaskEntity(
                    employee, obTask, "", null, null, "", TaskStatus.ASSIGNED
            );
            employeeHasOnboardingTaskList.add(employeeHasOnboardingTask);
        }
        return employeeHasOnboardingTaskMapper.mapEntityListToDetailDTOList(employeeHasOnboardingTaskRepository.saveAll(employeeHasOnboardingTaskList));
    }

    @Override
    public List<OnboardingTaskDetailDTO> updateEmployeeOnboardingTask(Integer id, Integer onboardingTaskId, OnboardingTaskUpdateDTO onboardingTaskUpdateDTO) {
        EmployeeHasOnboardingTaskEntity onboardingTask = getById(onboardingTaskId);
        employeeHasOnboardingTaskMapper.mapUpdateDTOToEntity(onboardingTaskUpdateDTO, onboardingTask);
        return getEmployeeOnboardingTasks(id);
    }

    @Override
    public void deleteEmployeeOnboardingTask(Integer id, Integer onboardingTaskId) {
        EmployeeHasOnboardingTaskEntity onboardingTask = getById(onboardingTaskId);
        employeeHasOnboardingTaskRepository.delete(onboardingTask);
    }

    private EmployeeHasOnboardingTaskEntity getById(Integer id) {
        return employeeHasOnboardingTaskRepository.findById(id).orElseThrow(
                () -> new NotFoundException(new ErrorMessagePayload(HttpStatus.NOT_FOUND, ErrorMessage.NOT_FOUND, "Onboarding Task with id " + id + " does not exist"))
        );
    }
}
