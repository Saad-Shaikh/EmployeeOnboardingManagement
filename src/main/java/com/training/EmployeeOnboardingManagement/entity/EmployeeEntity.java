package com.training.EmployeeOnboardingManagement.entity;

import com.training.EmployeeOnboardingManagement.converter.DesignationConverter;
import com.training.EmployeeOnboardingManagement.converter.EmployeeStatusConverter;
import com.training.EmployeeOnboardingManagement.enums.Designation;
import com.training.EmployeeOnboardingManagement.enums.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @PastOrPresent(message = "Date of birth cannot be in the future")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Size(min = 10, max = 100)
    private String address;

    @Size(min = 10, max = 10)
    private String phone;

    @NotNull(message = "Designation cannot be null")
    @Convert(converter = DesignationConverter.class)
    private Designation designation;

    @PastOrPresent(message = "Onboarding Start Date cannot be in the future")
    @Temporal(TemporalType.DATE)
    private Date onboardingStartDate;

    @FutureOrPresent(message = "Onboarding End Date cannot be in the past")
    @Temporal(TemporalType.DATE)
    private Date onboardingEndDate;

//    @ManyToMany
//    @JoinTable(
//            name = "employee_has_mentors",
//            joinColumns = @JoinColumn(name = "employee_id"),
//            inverseJoinColumns = @JoinColumn(name = "mentor_id")
//    )
//    private Set<EmployeeEntity> mentoredBy = new HashSet<>();
//
//    @ManyToMany
//    @JoinTable(
//            name = "employee_has_mentors",
//            joinColumns = @JoinColumn(name = "mentor_id"),
//            inverseJoinColumns = @JoinColumn(name = "employee_id")
//    )
//    private Set<EmployeeEntity> mentorOf = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_project", referencedColumnName = "id")
    private ProjectEntity project;

    @NotNull(message = "Status cannot be null")
    @Convert(converter = EmployeeStatusConverter.class)
    private EmployeeStatus status;
}
