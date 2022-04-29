package com.training.EmployeeOnboardingManagement.exception;

import lombok.Data;

@Data
public abstract class GenericException extends RuntimeException {
    protected ErrorMessagePayload errorMessagePayload;

    public GenericException(ErrorMessagePayload message) {
        super(message.getDeveloperMessage());
        this.errorMessagePayload = message;
    }
}
