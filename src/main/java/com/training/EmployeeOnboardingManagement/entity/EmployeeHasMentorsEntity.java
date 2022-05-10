package com.training.EmployeeOnboardingManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "employee_has_mentors")
@IdClass(EmployeeHasMentorsId.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeHasMentorsEntity {
    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Id
    @Column(name = "mentor_id")
    private Integer mentorId;
}
