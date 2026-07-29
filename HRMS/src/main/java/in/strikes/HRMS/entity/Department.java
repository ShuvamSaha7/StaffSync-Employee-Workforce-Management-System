package in.strikes.HRMS.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name="departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    private String description;



    // Employee Mapping

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;


}