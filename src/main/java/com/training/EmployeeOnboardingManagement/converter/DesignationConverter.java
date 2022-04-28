package com.training.EmployeeOnboardingManagement.converter;

import com.training.EmployeeOnboardingManagement.enums.Designation;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter
public class DesignationConverter implements AttributeConverter<Designation, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Designation designation) {
        return designation.getId();
    }

    @Override
    public Designation convertToEntityAttribute(Integer dbData) {
        return Arrays.stream(Designation.values()).filter(designation -> designation.getId() == dbData).findFirst().get();
    }
}
