package com.training.EmployeeOnboardingManagement.entity;

import com.training.EmployeeOnboardingManagement.converter.TaskStatusConverter;
import com.training.EmployeeOnboardingManagement.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "project_has_project_task")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectHasProjectTaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_project", referencedColumnName = "id")
    private ProjectEntity project;

    @ManyToOne(cascade = CascadeType.ALL)
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

    public ProjectHasProjectTaskEntity(ProjectEntity project, TaskEntity task, String remarks, LocalDate startDate, LocalDate endDate, String links, TaskStatus status) {
        this.project = project;
        this.task = task;
        this.remarks = remarks;
        this.startDate = startDate;
        this.endDate = endDate;
        this.links = links;
        this.status = status;
    }
}
