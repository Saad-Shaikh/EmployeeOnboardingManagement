package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.entity.EmployeeEntity;
import com.training.EmployeeOnboardingManagement.entity.ProjectEntity;
import com.training.EmployeeOnboardingManagement.entity.TaskEntity;

import java.util.List;

public interface EmployeeService {
    List<EmployeeEntity> getAllEmployees();
    EmployeeEntity createEmployee(EmployeeEntity employee);
    EmployeeEntity getEmployeeById(Integer id);
    EmployeeEntity updateEmployeeById(Integer id, EmployeeEntity newEmployee);
    EmployeeEntity updateEmployeeStatusById(Integer id, String status);

    /*
    Move to OnboardingService
    List<TaskEntity> getEmployeeOnboardingTasks(Integer id);
    TaskEntity addEmployeeOnboardingTask(Integer id, TaskEntity onboardingTask);
    TaskEntity updateEmployeeOnboardingTask(Integer id, TaskEntity onboardingTask);
    String updateEmployeeOnboardingTaskStatus(Integer id, Integer taskId, String status);
    void deleteEmployeeOnboardingTask(Integer id, Integer taskId);
    */
}
