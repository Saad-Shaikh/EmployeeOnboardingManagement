package com.training.EmployeeOnboardingManagement.dto;

import com.training.EmployeeOnboardingManagement.enums.Designation;
import com.training.EmployeeOnboardingManagement.enums.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetailDTO {
    private Integer id;
    private String name;
    private LocalDate dob;
    private String address;
    private String phone;
    private Designation designation;
    private LocalDate onboardingStartDate;
    private LocalDate onboardingEndDate;
    private Set<EmployeeListDTO> mentors;
    private EmployeeStatus status;
}
