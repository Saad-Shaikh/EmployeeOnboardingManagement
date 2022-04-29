package com.training.EmployeeOnboardingManagement.dto;

import com.training.EmployeeOnboardingManagement.enums.Designation;
import com.training.EmployeeOnboardingManagement.enums.EmployeeStatus;
import lombok.Data;

// just for learning
@Data
public class EmployeeSearchDTO {
    private String name;
    private String address;
    private String phone;
}
