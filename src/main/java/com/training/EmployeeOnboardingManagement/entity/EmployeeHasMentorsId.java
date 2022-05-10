package com.training.EmployeeOnboardingManagement.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class EmployeeHasMentorsId implements Serializable {
    private Integer employeeId;

    private Integer mentorId;
}
