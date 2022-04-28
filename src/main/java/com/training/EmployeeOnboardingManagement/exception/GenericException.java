package com.training.EmployeeOnboardingManagement.exception;

public abstract class GenericException extends RuntimeException {
    public GenericException(String message) {
        super(message);
    }
}
