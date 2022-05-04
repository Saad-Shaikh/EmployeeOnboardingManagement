package com.training.EmployeeOnboardingManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "repo_url")
    private String repoUrl;

    @JsonIgnore
    @OneToOne(mappedBy = "project")
    private EmployeeEntity employee;

    @JsonIgnore
    @OneToMany(mappedBy = "project")
    private Set<ProjectHasProjectTaskEntity> projectHasProjectTaskSet = new HashSet<>();
}
