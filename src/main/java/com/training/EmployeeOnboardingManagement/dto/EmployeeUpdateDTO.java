package com.training.EmployeeOnboardingManagement.dto;

import com.training.EmployeeOnboardingManagement.enums.Designation;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EmployeeUpdateDTO {
    @NotNull()
    private String name;

    @NotNull()
    private String address;

    @NotNull()
    private String phone;

    @NotNull()
    private Designation designation;

    @NotNull()
    private LocalDate onboardingEndDate;
}
