package com.training.EmployeeOnboardingManagement.validator;

import com.training.EmployeeOnboardingManagement.enums.ErrorMessage;
import com.training.EmployeeOnboardingManagement.exception.BadRequestException;
import com.training.EmployeeOnboardingManagement.exception.ErrorMessagePayload;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public abstract class GenericValidator {
    protected void throwBadRequestIfViolationsExist(Map<String, String> violations) {
        if (!violations.isEmpty()) {
            throw new BadRequestException(new ErrorMessagePayload(HttpStatus.BAD_REQUEST, ErrorMessage.BAD_REQUEST, violations));
        }
    }
}
