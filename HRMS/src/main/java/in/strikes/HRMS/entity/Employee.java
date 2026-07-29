package in.strikes.HRMS.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @NotBlank(message = "Name is required")
    private String name;



    @NotBlank(message = "Email is required")
    @Email(message = "Enter valid email")
    @Column(unique = true)
    private String email;



    @NotBlank(message = "Phone is required")
    private String phone;



    @NotBlank(message = "Designation is required")
    private String designation;



    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be positive")
    private Double salary;



    private LocalDate joiningDate;




    // Department Mapping

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;





    // Project Mapping

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;


}