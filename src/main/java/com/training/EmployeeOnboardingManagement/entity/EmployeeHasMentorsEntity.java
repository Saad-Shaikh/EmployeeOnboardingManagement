package com.training.EmployeeOnboardingManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_has_mentors")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeHasMentorsEntity {
    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "mentor_id")
    private Integer mentorId;
}
