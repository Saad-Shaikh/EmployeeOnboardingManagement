package com.training.EmployeeOnboardingManagement.exception;

import com.training.EmployeeOnboardingManagement.enums.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ErrorMessagePayload {
    private final HttpStatus httpStatus;
    private final ErrorMessage errorMessage;
    private final String developerMessage;
}
