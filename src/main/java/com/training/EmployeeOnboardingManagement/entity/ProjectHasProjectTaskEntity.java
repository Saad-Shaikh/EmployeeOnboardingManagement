package com.training.EmployeeOnboardingManagement.entity;

import com.training.EmployeeOnboardingManagement.converter.TaskStatusConverter;
import com.training.EmployeeOnboardingManagement.converter.TaskTypeConverter;
import com.training.EmployeeOnboardingManagement.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "project_has_project_task_entity")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectHasProjectTaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_project", referencedColumnName = "id")
    private ProjectEntity project;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_task", referencedColumnName = "id")
    private TaskEntity task;
    private String remarks;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Temporal(TemporalType.DATE)
    private Date endDate;
    private String links;
    @Convert(converter = TaskStatusConverter.class)
    private TaskStatus status;

    public ProjectHasProjectTaskEntity(ProjectEntity project, TaskEntity task, String remarks, Date startDate, Date endDate, String links, TaskStatus status) {
        this.project = project;
        this.task = task;
        this.remarks = remarks;
        this.startDate = startDate;
        this.endDate = endDate;
        this.links = links;
        this.status = status;
    }
}
