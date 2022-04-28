package com.training.EmployeeOnboardingManagement.converter;

import com.training.EmployeeOnboardingManagement.enums.TaskType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter
public class TaskTypeConverter implements AttributeConverter<String, Integer> {
    @Override
    public Integer convertToDatabaseColumn(String attribute) {
        return Arrays.stream(TaskType.values()).filter(taskType -> taskType.getValue().equals(attribute)).findFirst().get().getId();
    }

    @Override
    public String convertToEntityAttribute(Integer dbData) {
        return Arrays.stream(TaskType.values()).filter(taskType -> taskType.getId() == dbData).findFirst().get().getValue();
    }
}
