package com.training.EmployeeOnboardingManagement.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Designation {
    SOFTWARE_ENGINEER(1, "Software Engineer"),
    SENIOR_SOFTWARE_ENGINEER(2, "Senior Software Engineer"),
    PROJECT_LEAD(3, "Project Lead"),
    PROJECT_MANAGER(4, "Project Manager");

    private final Integer id;
    private final String value;
}
