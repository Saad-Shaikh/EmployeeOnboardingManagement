package com.training.EmployeeOnboardingManagement.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskType {
    ONBOARDING(1, "Onboarding"),
    PROJECT(2, "Project");

    private final Integer id;
    private final String value;
}
