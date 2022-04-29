package com.training.EmployeeOnboardingManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends GenericException {
    public NotFoundException(ErrorMessagePayload message) {
        super(message);
    }
}
