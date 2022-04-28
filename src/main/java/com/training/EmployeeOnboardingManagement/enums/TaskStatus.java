package com.training.EmployeeOnboardingManagement.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskStatus {
    ASSIGNED(1, "Assigned"),
    IN_PROGRESS(2, "In Progress"),
    COMPLETED(3, "Completed");

    private final Integer id;
    private final String value;
}
