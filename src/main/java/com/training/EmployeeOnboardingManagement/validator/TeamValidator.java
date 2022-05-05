package com.training.EmployeeOnboardingManagement.validator;

import com.training.EmployeeOnboardingManagement.dto.TeamCreateDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TeamValidator extends GenericValidator {
    public void validate(TeamCreateDTO teamCreateDTO) {
        Map<String, String> violations = new HashMap<>();
        if (teamCreateDTO.getName().length() == 0) {
            violations.put("name", "Team name cannot be blank");
        }

        throwBadRequestIfViolationsExist(violations);
    }
}
