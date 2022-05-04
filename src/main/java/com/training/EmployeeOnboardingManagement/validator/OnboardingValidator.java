package com.training.EmployeeOnboardingManagement.validator;

import com.training.EmployeeOnboardingManagement.dto.OnboardingTaskAssignDTO;
import com.training.EmployeeOnboardingManagement.dto.OnboardingTaskUpdateDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class OnboardingValidator extends GenericValidator {
    public void validate(OnboardingTaskAssignDTO onboardingTaskAssignDTO) {
        Map<String, String> violations = new HashMap<>();
        if (onboardingTaskAssignDTO.getTaskList().size() == 0) {
            violations.put("taskList", "Task List cannot be empty");
        }

        throwBadRequestIfViolationsExist(violations);
    }

    public void validate(OnboardingTaskUpdateDTO onboardingTaskUpdateDTO) {
        Map<String, String> violations = new HashMap<>();
        if (onboardingTaskUpdateDTO.getStartDate().isBefore(LocalDate.now())) {
            violations.put("startDate", "Start date cannot be in the past");
        }
        if (onboardingTaskUpdateDTO.getEndDate().isBefore(LocalDate.now())) {
            violations.put("endDate", "End date cannot be in the past");
        }

        throwBadRequestIfViolationsExist(violations);
    }
}
