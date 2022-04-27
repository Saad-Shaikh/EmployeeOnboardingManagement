package com.training.EmployeeOnboardingManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectHasProjectTaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private ProjectEntity project;
    private TaskEntity task;
    private String remarks;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private String links;
    private String status;

    public ProjectHasProjectTaskEntity(ProjectEntity project, TaskEntity task, String remarks, Date startDate, Date endDate, String links, String status) {
        this.project = project;
        this.task = task;
        this.remarks = remarks;
        this.startDate = startDate;
        this.endDate = endDate;
        this.links = links;
        this.status = status;
    }
}
