package com.training.EmployeeOnboardingManagement.dto;

import com.training.EmployeeOnboardingManagement.enums.Designation;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeUpdateDTO {
    private String name;
    private Date dob;
    private String address;
    private String phone;
    private Designation designation;
    private Date onboardingEndDate;
}
