package com.training.EmployeeOnboardingManagement.validator;

import com.training.EmployeeOnboardingManagement.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

@Component
@AllArgsConstructor
public class EmployeeValidator {
    private Validator validator;

    public void validateEmployee(EmployeeEntity employee) {
        Set<ConstraintViolation<EmployeeEntity>> violations = validator.validate(employee);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
