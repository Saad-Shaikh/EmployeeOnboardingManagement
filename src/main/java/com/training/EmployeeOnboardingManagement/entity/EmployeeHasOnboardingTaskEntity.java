package com.training.EmployeeOnboardingManagement.entity;

import com.training.EmployeeOnboardingManagement.converter.TaskStatusConverter;
import com.training.EmployeeOnboardingManagement.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee_has_onboarding_task")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeHasOnboardingTaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "ref_employee", referencedColumnName = "id")
    private EmployeeEntity employee;

    @ManyToOne()
    @JoinColumn(name = "ref_task", referencedColumnName = "id")
    private TaskEntity task;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "links")
    private String links;

    @Convert(converter = TaskStatusConverter.class)
    @Column(name = "status")
    private TaskStatus status;

    public EmployeeHasOnboardingTaskEntity(EmployeeEntity employee, TaskEntity task, String remarks, LocalDate startDate, LocalDate endDate, String links, TaskStatus status) {
        this.employee = employee;
        this.task = task;
        this.remarks = remarks;
        this.startDate = startDate;
        this.endDate = endDate;
        this.links = links;
        this.status = status;
    }
}
