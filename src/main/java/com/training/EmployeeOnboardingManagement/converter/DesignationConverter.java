package com.training.EmployeeOnboardingManagement.converter;

import com.training.EmployeeOnboardingManagement.enums.Designation;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter
public class DesignationConverter implements AttributeConverter<String, Integer> {
    @Override
    public Integer convertToDatabaseColumn(String attribute) {
        return Arrays.stream(Designation.values()).filter(designation -> designation.getValue().equals(attribute)).findFirst().get().getId();
    }

    @Override
    public String convertToEntityAttribute(Integer dbData) {
        return Arrays.stream(Designation.values()).filter(designation -> designation.getId() == dbData).findFirst().get().getValue();
    }
}
