package com.training.EmployeeOnboardingManagement.converter;

import com.training.EmployeeOnboardingManagement.enums.TaskType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter
public class TaskTypeConverter implements AttributeConverter<TaskType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(TaskType taskType) {
        return taskType.getId();
    }

    @Override
    public TaskType convertToEntityAttribute(Integer dbData) {
        return Arrays.stream(TaskType.values()).filter(taskType -> taskType.getId() == dbData).findFirst().get();
    }
}
