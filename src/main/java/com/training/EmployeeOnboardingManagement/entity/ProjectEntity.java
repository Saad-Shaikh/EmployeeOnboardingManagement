package com.training.EmployeeOnboardingManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    private String repoUrl;

    public ProjectEntity(String name, String description, String repoUrl) {
        this.name = name;
        this.description = description;
        this.repoUrl = repoUrl;
    }
}
