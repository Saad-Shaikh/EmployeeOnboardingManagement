package com.training.EmployeeOnboardingManagement.dataproviders;

import com.training.EmployeeOnboardingManagement.dto.EmployeeCreateDTO;
import com.training.EmployeeOnboardingManagement.dto.EmployeeStatusPatchDTO;
import com.training.EmployeeOnboardingManagement.dto.EmployeeUpdateDTO;
import com.training.EmployeeOnboardingManagement.enums.Designation;
import com.training.EmployeeOnboardingManagement.enums.EmployeeStatus;
import org.testng.annotations.DataProvider;

import java.time.LocalDate;

public class EmployeeTestDataProvider {
    @DataProvider
    public Object[][] getEmployeeCreateDTO() {
        return new Object[][] {{new EmployeeCreateDTO("Saad", LocalDate.of(1997, 11, 16), "NIBM, Pune", "0123456789", Designation.SOFTWARE_ENGINEER, LocalDate.now(), LocalDate.of(2022, 12, 01), EmployeeStatus.ON_PROBATION)}};
    }

    @DataProvider
    public Object[][] getEmployeeUpdateDTO() {
        return new Object[][] {{new EmployeeUpdateDTO("Saad1", "Baner, Pune", "1234567890", Designation.SENIOR_SOFTWARE_ENGINEER, LocalDate.now())}};
    }

    @DataProvider
    public Object[][] getEmployeeStatusPatchDTO() {
        return new Object[][] {{new EmployeeStatusPatchDTO(1, EmployeeStatus.ACTIVE)}};
    }
}
