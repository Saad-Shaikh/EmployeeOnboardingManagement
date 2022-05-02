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
    private Integer id;
    private String name;
    private String description;
    private String repoUrl;
    @JsonIgnore
    @OneToMany(mappedBy = "project")
    private Set<ProjectHasProjectTaskEntity> projectHasProjectTaskSet = new HashSet<>();

    public ProjectEntity(String name, String description, String repoUrl) {
        this.name = name;
        this.description = description;
        this.repoUrl = repoUrl;
    }
}
