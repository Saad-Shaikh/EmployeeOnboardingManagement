package com.training.EmployeeOnboardingManagement.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    NOT_FOUND(1, "Unable to find requested resource"),
    BAD_REQUEST(2, "Bad request received from client");

    private final Integer id;
    private final String value;
}
