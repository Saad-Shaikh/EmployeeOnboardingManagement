package com.training.EmployeeOnboardingManagement.exception;

import com.training.EmployeeOnboardingManagement.enums.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
public class ErrorMessagePayload {
    private HttpStatus httpStatus;
    private ErrorMessage errorMessage;
    private String developerMessage;
    private Map<String, String> developerMessages;

    public ErrorMessagePayload(HttpStatus httpStatus, ErrorMessage errorMessage, String developerMessage) {
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
        this.developerMessage = developerMessage;
    }

    public ErrorMessagePayload(HttpStatus httpStatus, ErrorMessage errorMessage, Map<String, String> developerMessages) {
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
        this.developerMessages = developerMessages;
    }
}
