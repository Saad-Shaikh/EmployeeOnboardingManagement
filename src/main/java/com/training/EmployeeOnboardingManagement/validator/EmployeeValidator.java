package com.training.EmployeeOnboardingManagement.validator;

import com.training.EmployeeOnboardingManagement.dto.EmployeeCreateDTO;
import com.training.EmployeeOnboardingManagement.dto.EmployeeUpdateDTO;
import com.training.EmployeeOnboardingManagement.enums.ErrorMessage;
import com.training.EmployeeOnboardingManagement.exception.BadRequestException;
import com.training.EmployeeOnboardingManagement.exception.ErrorMessagePayload;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Component
public class EmployeeValidator extends GenericValidator {
    public void validate(EmployeeCreateDTO employee) {
        Map<String, String> violations = new HashMap<>();
        String phoneRegex = "[0-9]{10}";

        if (employee.getName().length() == 0) {
            violations.put("name", "Name cannot be blank");
        }
        if (employee.getDob().isAfter(LocalDate.now())) {
            violations.put("dob", "Date of birth cannot be in the future");
        }
        if (employee.getAddress().length() < 10 || employee.getAddress().length() > 100) {
            violations.put("address", "Address should be between 10 and 100 characters long");
        }
        if (employee.getPhone().length() != 10 || employee.getPhone().startsWith("0") || !Pattern.matches(phoneRegex, employee.getPhone())) {
            violations.put("phone", "Phone should be a valid 10 digit number");
        }
        if (employee.getOnboardingStartDate().isAfter(LocalDate.now())) {
            violations.put("onboardingStartDate", "Onboarding Start Date cannot be in the future");
        }
        if (employee.getOnboardingEndDate().isBefore(LocalDate.now())) {
            violations.put("onboardingStartDate", "Onboarding End Date cannot be in the past");
        }

        throwBadRequestIfViolationsExist(violations);
    }

    public void validate(EmployeeUpdateDTO employee) {
        Map<String, String> violations = new HashMap<>();
        String phoneRegex = "[0-9]{10}";

        if (employee.getName().length() == 0) {
            violations.put("name", "Name cannot be blank");
        }
        if (employee.getAddress().length() < 10 || employee.getAddress().length() > 100) {
            violations.put("address", "Address should be between 10 and 100 characters long");
        }
        if (employee.getPhone().length() != 10 || employee.getPhone().startsWith("0") || !Pattern.matches(phoneRegex, employee.getPhone())) {
            violations.put("phone", "Phone should be a valid 10 digit number");
        }
        if (employee.getOnboardingEndDate().isBefore(LocalDate.now())) {
            violations.put("onboardingStartDate", "Onboarding End Date cannot be in the past");
        }

        throwBadRequestIfViolationsExist(violations);
    }
}
