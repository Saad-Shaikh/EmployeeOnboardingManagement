package com.training.EmployeeOnboardingManagement.exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Map;

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
            if (cause.getErrorMessagePayload().getDeveloperMessage() != null) {
                errorAttribute.put("developerMessage", cause.getErrorMessagePayload().getDeveloperMessage());
            }
            if (cause.getErrorMessagePayload().getDeveloperMessages() != null) {
                errorAttribute.put("developerMessages", cause.getErrorMessagePayload().getDeveloperMessages());
            }
        }
        return errorAttribute;
    }
}