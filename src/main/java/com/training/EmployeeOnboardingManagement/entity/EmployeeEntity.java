package com.training.EmployeeOnboardingManagement.entity;

import com.training.EmployeeOnboardingManagement.enums.Designation;
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
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dob;
    private String address;
    private String phone;
    private Designation designation;
    @Temporal(TemporalType.DATE)
    private Date onboardingStartDate;
    @Temporal(TemporalType.DATE)
    private Date onboardingEndDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_project_id", referencedColumnName = "id")
    private ProjectEntity project;
    private String status;

    public EmployeeEntity(String name, Date dob, String address, String phone, Designation designation, Date onboardingStartDate, Date onboardingEndDate, ProjectEntity project, String status) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.designation = designation;
        this.onboardingStartDate = onboardingStartDate;
        this.onboardingEndDate = onboardingEndDate;
        this.project = project;
        this.status = status;
    }

//    for EmployeeDTOToEmployee conversion
    public EmployeeEntity(Integer id, String name, Date dob, String address, String phone, Designation designation, Date onboardingStartDate, Date onboardingEndDate, String status) {
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
