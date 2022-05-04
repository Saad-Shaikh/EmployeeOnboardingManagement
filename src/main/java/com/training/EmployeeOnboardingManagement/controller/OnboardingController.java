package com.training.EmployeeOnboardingManagement.controller;

import com.training.EmployeeOnboardingManagement.dto.OnboardingTaskAssignDTO;
import com.training.EmployeeOnboardingManagement.dto.OnboardingTaskDetailDTO;
import com.training.EmployeeOnboardingManagement.dto.OnboardingTaskUpdateDTO;
import com.training.EmployeeOnboardingManagement.service.EmployeeHasOnboardingTaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/employees/{id}/onboarding")
@AllArgsConstructor
public class OnboardingController {
    private final EmployeeHasOnboardingTaskService employeeHasOnboardingTaskService;

    @GetMapping()
    public List<OnboardingTaskDetailDTO> getEmployeeOnboardingTasks(@PathVariable("id") Integer id) {
        return employeeHasOnboardingTaskService.getEmployeeOnboardingTasks(id);
    }

    @PostMapping List<OnboardingTaskDetailDTO> addEmployeeOnboardingTasks(@PathVariable("id") Integer id, @RequestBody @Valid OnboardingTaskAssignDTO onboardingTaskAssignDTO) {
        return employeeHasOnboardingTaskService.addEmployeeOnboardingTasks(id, onboardingTaskAssignDTO);
    }

    @PutMapping(path = "{onboardingTaskId}")
    public List<OnboardingTaskDetailDTO> updateEmployeeOnboardingTask(@PathVariable("id") Integer id, @PathVariable("onboardingTaskId") Integer onboardingTaskId, @RequestBody @Valid OnboardingTaskUpdateDTO onboardingTaskUpdateDTO) {
        return employeeHasOnboardingTaskService.updateEmployeeOnboardingTask(id, onboardingTaskId, onboardingTaskUpdateDTO);
    }

    @DeleteMapping(path = "{onboardingTaskId}")
    public void deleteEmployeeOnboardingTask(@PathVariable("id") Integer id, @PathVariable("onboardingTaskId") Integer onboardingTaskId) {
        employeeHasOnboardingTaskService.deleteEmployeeOnboardingTask(id, onboardingTaskId);
    }
}
