package com.training.EmployeeOnboardingManagement.exception;

import com.training.EmployeeOnboardingManagement.enums.ErrorMessage;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class MyCustomErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttribute = super.getErrorAttributes(webRequest, options);
        errorAttribute.put("timestamp", LocalDateTime.now());
        Throwable error = getError(webRequest);
        if (error instanceof GenericException) {
            GenericException cause = (GenericException) error;
            errorAttribute.put("code", cause.getErrorMessagePayload().getHttpStatus());
            errorAttribute.put("errorMessage", cause.getErrorMessagePayload().getErrorMessage().getValue());
            errorAttribute.put("developerMessage", cause.getErrorMessagePayload().getDeveloperMessage());
        } else if (error instanceof ConstraintViolationException) {
            ConstraintViolationException cause = (ConstraintViolationException) error;
            errorAttribute.put("status", HttpStatus.BAD_REQUEST.value());
            errorAttribute.put("error", "Constraints violated");
            errorAttribute.put("code", HttpStatus.BAD_REQUEST);
            errorAttribute.put("errorMessage", ErrorMessage.BAD_REQUEST.getValue());
            errorAttribute.put("developerMessage", getConstraintViolationMapFromSet(cause.getConstraintViolations()));
        }
        return errorAttribute;
    }

    private Map<String, String> getConstraintViolationMapFromSet(Set<ConstraintViolation<?>> constraintViolations) {
        Map<String, String> violations = new HashMap<>();
        for (ConstraintViolation<?> violation : constraintViolations) {
            violations.put(violation.getPropertyPath().toString(), violation.getMessage());
        }
        return violations;
    }
}