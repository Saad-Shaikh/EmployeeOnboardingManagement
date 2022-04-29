package com.training.EmployeeOnboardingManagement.dto;

import com.training.EmployeeOnboardingManagement.enums.Designation;
import com.training.EmployeeOnboardingManagement.enums.EmployeeStatus;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class EmployeeDetailDTO {
    private Integer id;
    private String name;
    private Date dob;
    private String address;
    private String phone;
    private Designation designation;
    private Date onboardingStartDate;
    private Date onboardingEndDate;
    private Set<EmployeeDetailDTO> mentoredBy;
    private EmployeeStatus status;
}
