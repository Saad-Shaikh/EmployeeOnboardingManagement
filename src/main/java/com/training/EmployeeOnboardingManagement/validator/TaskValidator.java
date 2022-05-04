package com.training.EmployeeOnboardingManagement.validator;

import com.training.EmployeeOnboardingManagement.dto.TaskCreateDTO;
import com.training.EmployeeOnboardingManagement.dto.TaskUpdateDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TaskValidator extends GenericValidator {
    public void validate(TaskCreateDTO taskCreateDTO) {
        Map<String, String> violations = new HashMap<>();
        if (taskCreateDTO.getTask().length() == 0) {
            violations.put("task", "Task cannot be blank");
        }

        throwBadRequestIfViolationsExist(violations);
    }

    public void validate(TaskUpdateDTO taskUpdateDTO) {
        Map<String, String> violations = new HashMap<>();
        if (taskUpdateDTO.getTask().length() == 0) {
            violations.put("task", "Task cannot be blank");
        }

        throwBadRequestIfViolationsExist(violations);
    }
}
