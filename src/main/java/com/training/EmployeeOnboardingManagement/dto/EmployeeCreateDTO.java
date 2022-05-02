package com.training.EmployeeOnboardingManagement.dto;

import com.training.EmployeeOnboardingManagement.enums.Designation;
import com.training.EmployeeOnboardingManagement.enums.EmployeeStatus;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class EmployeeCreateDTO {
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @PastOrPresent(message = "Date of birth cannot be in the future")
    private Date dob;

    @Size(min = 10, max = 100)
    private String address;

    @Size(min = 10, max = 10)
    private String phone;

    @NotNull(message = "Designation cannot be null")
    private Designation designation;

    @PastOrPresent(message = "Onboarding Start Date cannot be in the future")
    private Date onboardingStartDate;

    @FutureOrPresent(message = "Onboarding End Date cannot be in the past")
    private Date onboardingEndDate;

    @NotNull(message = "Status cannot be null")
    private EmployeeStatus status;
}
