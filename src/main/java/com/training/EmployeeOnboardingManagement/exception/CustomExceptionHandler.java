package com.training.EmployeeOnboardingManagement.exception;

import com.training.EmployeeOnboardingManagement.enums.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessagePayload> handleNotFoundException(NotFoundException exception) {
        ErrorMessagePayload payload = new ErrorMessagePayload(ZonedDateTime.now(), ErrorMessage.NOT_FOUND.getValue(), exception.getMessage());
        return new ResponseEntity<ErrorMessagePayload>(payload, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorMessagePayload> handleBadRequestException(BadRequestException exception) {
        ErrorMessagePayload payload = new ErrorMessagePayload(ZonedDateTime.now(), ErrorMessage.BAD_REQUEST.getValue(), exception.getMessage());
        return new ResponseEntity<ErrorMessagePayload>(payload, HttpStatus.BAD_REQUEST);
    }
}
