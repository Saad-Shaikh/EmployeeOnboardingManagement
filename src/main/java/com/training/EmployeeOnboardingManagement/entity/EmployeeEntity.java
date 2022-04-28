package com.training.EmployeeOnboardingManagement.entity;

import com.training.EmployeeOnboardingManagement.converter.DesignationConverter;
import com.training.EmployeeOnboardingManagement.converter.EmployeeStatusConverter;
import com.training.EmployeeOnboardingManagement.enums.Designation;
import com.training.EmployeeOnboardingManagement.enums.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dob;
    private String address;
    private String phone;
    @Convert(converter = DesignationConverter.class)
    private Designation designation;
    @Temporal(TemporalType.DATE)
    private Date onboardingStartDate;
    @Temporal(TemporalType.DATE)
    private Date onboardingEndDate;
    @ManyToMany
    @JoinTable(
            name = "employee_has_mentors",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "mentor_id")
    )
    private Set<EmployeeEntity> mentoredBy = new HashSet<>();
    @ManyToMany
    @JoinTable(
            name = "employee_has_mentors",
            joinColumns = @JoinColumn(name = "mentor_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private Set<EmployeeEntity> mentorOf = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_project", referencedColumnName = "id")
    private ProjectEntity project;
    @Convert(converter = EmployeeStatusConverter.class)
    private EmployeeStatus status;

    public EmployeeEntity(Integer id, String name, Date dob, String address, String phone, Designation designation, Date onboardingStartDate, Date onboardingEndDate, EmployeeStatus status) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.designation = designation;
        this.onboardingStartDate = onboardingStartDate;
        this.onboardingEndDate = onboardingEndDate;
        this.status = status;
    }
}
