package com.training.EmployeeOnboardingManagement.dto;

import com.training.EmployeeOnboardingManagement.enums.Designation;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EmployeeUpdateDTO {
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Size(min = 10, max = 100)
    private String address;

    @Size(min = 10, max = 10)
    private String phone;

    @NotNull(message = "Designation cannot be null")
    private Designation designation;

    @FutureOrPresent(message = "Onboarding End Date cannot be in the past")
    private LocalDate onboardingEndDate;
}
