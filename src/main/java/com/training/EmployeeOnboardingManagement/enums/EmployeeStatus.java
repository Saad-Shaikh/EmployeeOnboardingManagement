package com.training.EmployeeOnboardingManagement.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmployeeStatus {
    ON_PROBATION(1, "On Probation"),
    ACTIVE(2, "Active"),
    INACTIVE(3, "Inactive");

    private final Integer id;
    private final String value;
}
