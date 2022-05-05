package com.training.EmployeeOnboardingManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "team_has_employees")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeamHasEmployeesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ref_team", referencedColumnName = "id")
    private TeamEntity team;

    @ManyToOne
    @JoinColumn(name = "ref_employee", referencedColumnName = "id")
    private EmployeeEntity employee;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    public TeamHasEmployeesEntity(TeamEntity team, EmployeeEntity employee, LocalDate startDate) {
        this.team = team;
        this.employee = employee;
        this.startDate = startDate;
    }
}
