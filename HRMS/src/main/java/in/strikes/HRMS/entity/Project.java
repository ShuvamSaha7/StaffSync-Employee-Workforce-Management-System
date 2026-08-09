package in.strikes.HRMS.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Project name is required")
    private String projectName;

    @NotBlank(message = "Project description is required")
    @Column(length = 500)
    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    @NotBlank(message = "Project status is required")
    private String status;


    // Department Mapping

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


    // Employee Mapping

    @OneToMany(mappedBy = "project")
    private List<Employee> employees;

}