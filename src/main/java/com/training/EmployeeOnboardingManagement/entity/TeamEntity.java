package com.training.EmployeeOnboardingManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "team")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "team")
    @ToString.Exclude
    private Set<TeamHasEmployeesEntity> teamHasEmployeesSet = new HashSet<>();

}
