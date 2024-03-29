package com.training.EmployeeOnboardingManagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.training.EmployeeOnboardingManagement.converter.DesignationConverter;
import com.training.EmployeeOnboardingManagement.converter.EmployeeStatusConverter;
import com.training.EmployeeOnboardingManagement.enums.Designation;
import com.training.EmployeeOnboardingManagement.enums.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Convert(converter = DesignationConverter.class)
    @Column(name = "designation")
    private Designation designation;

    @Column(name = "onboarding_start_date")
    private LocalDate onboardingStartDate;

    @Column(name = "onboarding_end_date")
    private LocalDate onboardingEndDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "employee_has_mentors",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "mentor_id")
    )
    @ToString.Exclude
    @JsonManagedReference
    private Set<EmployeeEntity> mentoredBy = new HashSet<>();

    @ManyToMany(mappedBy = "mentoredBy")
    @ToString.Exclude
    @JsonBackReference
    private Set<EmployeeEntity> mentorOf = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_project", referencedColumnName = "id")
    @ToString.Exclude
    private ProjectEntity project;

    @Convert(converter = EmployeeStatusConverter.class)
    @Column(name = "status")
    private EmployeeStatus status;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    @ToString.Exclude
    private Set<TeamHasEmployeesEntity> employeePartOfTeamsSet = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    @ToString.Exclude
    private Set<EmployeeHasOnboardingTaskEntity> employeeHasOnboardingTasksSet = new HashSet<>();
}
