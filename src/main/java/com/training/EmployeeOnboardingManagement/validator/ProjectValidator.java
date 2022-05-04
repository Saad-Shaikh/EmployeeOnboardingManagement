package com.training.EmployeeOnboardingManagement.validator;

import com.training.EmployeeOnboardingManagement.dto.ProjectCreateDTO;
import com.training.EmployeeOnboardingManagement.dto.ProjectTaskUpdateDTO;
import com.training.EmployeeOnboardingManagement.dto.ProjectUpdateDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProjectValidator extends GenericValidator {
    public void validate(ProjectCreateDTO projectCreateDTO) {
        Map<String, String> violations = new HashMap<>();
        if (projectCreateDTO.getName().length() == 0) {
            violations.put("name", "Project name cannot be blank");
        }
        if (projectCreateDTO.getDescription().length() < 10 || projectCreateDTO.getDescription().length() > 100) {
            violations.put("description", "Description should be between 10 and 100 characters long");
        }
        if (projectCreateDTO.getRepoUrl().length() == 0) {
            violations.put("repoUrl", "Repository URL cannot be blank");
        }

        throwBadRequestIfViolationsExist(violations);
    }

    public void validate(ProjectUpdateDTO projectUpdateDTO) {
        Map<String, String> violations = new HashMap<>();
        if (projectUpdateDTO.getName().length() == 0) {
            violations.put("name", "Project name cannot be blank");
        }
        if (projectUpdateDTO.getDescription().length() < 10 || projectUpdateDTO.getDescription().length() > 100) {
            violations.put("description", "Description should be between 10 and 100 characters long");
        }

        throwBadRequestIfViolationsExist(violations);
    }

    public void validate(ProjectTaskUpdateDTO projectTaskUpdateDTO) {
        Map<String, String> violations = new HashMap<>();
        if (projectTaskUpdateDTO.getStartDate().isBefore(LocalDate.now())) {
            violations.put("startDate", "Start date cannot be in the past");
        }
        if (projectTaskUpdateDTO.getEndDate().isBefore(LocalDate.now())) {
            violations.put("endDate", "End date cannot be in the past");
        }

        throwBadRequestIfViolationsExist(violations);
    }
}
