package com.training.EmployeeOnboardingManagement.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter
public class ErrorMessagePayload {
    private final ZonedDateTime timestamp;
    private final String message;
    private final String details;
}
