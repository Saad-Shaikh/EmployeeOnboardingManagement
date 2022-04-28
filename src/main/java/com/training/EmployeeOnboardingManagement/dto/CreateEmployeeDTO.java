package com.training.EmployeeOnboardingManagement.dto;

import com.training.EmployeeOnboardingManagement.enums.Designation;
import com.training.EmployeeOnboardingManagement.enums.EmployeeStatus;
import lombok.Data;

import java.util.Date;

@Data
public class CreateEmployeeDTO {
    private String name;
    private Date dob;
    private String address;
    private String phone;
    private Designation designation;
    private Date onboardingStartDate;
    private Date onboardingEndDate;
    private EmployeeStatus status;
}
