package com.training.EmployeeOnboardingManagement.converter;

import com.training.EmployeeOnboardingManagement.enums.EmployeeStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter
public class EmployeeStatusConverter implements AttributeConverter<EmployeeStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(EmployeeStatus employeeStatus) {
        return employeeStatus.getId();
    }

    @Override
    public EmployeeStatus convertToEntityAttribute(Integer dbData) {
        return Arrays.stream(EmployeeStatus.values()).filter(employeeStatus -> employeeStatus.getId() == dbData).findFirst().get();
    }
}
