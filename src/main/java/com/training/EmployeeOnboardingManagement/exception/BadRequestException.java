package com.training.EmployeeOnboardingManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends GenericException {
    public BadRequestException(ErrorMessagePayload message) {
        super(message);
    }
}
