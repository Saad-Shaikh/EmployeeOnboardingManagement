package com.training.EmployeeOnboardingManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.training.EmployeeOnboardingManagement.converter.TaskTypeConverter;
import com.training.EmployeeOnboardingManagement.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "task")
    private String task;

    @Convert(converter = TaskTypeConverter.class)
    @Column(name = "task_type")
    private TaskType taskType;

    @JsonIgnore
    @OneToMany(mappedBy = "task")
    private Set<ProjectHasProjectTaskEntity> taskIsAssignedToProjectsSet = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "task")
    private Set<EmployeeHasOnboardingTaskEntity> taskIsAssignedToEmployeeSet = new HashSet<>();
}
