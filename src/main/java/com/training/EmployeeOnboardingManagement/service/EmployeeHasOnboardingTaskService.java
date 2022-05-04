package com.training.EmployeeOnboardingManagement.service;

import com.training.EmployeeOnboardingManagement.dto.OnboardingTaskAssignDTO;
import com.training.EmployeeOnboardingManagement.dto.OnboardingTaskDetailDTO;
import com.training.EmployeeOnboardingManagement.dto.OnboardingTaskUpdateDTO;

import java.util.List;

public interface EmployeeHasOnboardingTaskService {
    List<OnboardingTaskDetailDTO> getEmployeeOnboardingTasks(Integer id);

    List<OnboardingTaskDetailDTO> addEmployeeOnboardingTasks(Integer id, OnboardingTaskAssignDTO onboardingTaskAssignDTO);

    List<OnboardingTaskDetailDTO> updateEmployeeOnboardingTask(Integer id, Integer onboardingTaskId, OnboardingTaskUpdateDTO onboardingTaskUpdateDTO);

    void deleteEmployeeOnboardingTask(Integer id, Integer onboardingTaskId);
}
