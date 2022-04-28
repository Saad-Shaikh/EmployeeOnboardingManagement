package com.training.EmployeeOnboardingManagement.converter;

import com.training.EmployeeOnboardingManagement.enums.TaskStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

@Converter
public class TaskStatusConverter implements AttributeConverter<TaskStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(TaskStatus taskStatus) {
        return taskStatus.getId();
    }

    @Override
    public TaskStatus convertToEntityAttribute(Integer dbData) {
        return Arrays.stream(TaskStatus.values()).filter(taskStatus -> taskStatus.getId() == dbData).findFirst().get();
    }
}
