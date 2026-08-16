package in.strikes.HRMS.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "payroll")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Employee
    @NotNull(message = "Employee is required")
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    // Payroll month
    @NotBlank(message = "Payroll month is required")
    private String payrollMonth;

    // Basic salary
    @NotNull(message = "Basic salary is required")
    @Positive(message = "Basic salary must be positive")
    private Double basicSalary;

    // Allowance
    @NotNull(message = "Allowance is required")
    @PositiveOrZero(message = "Allowance cannot be negative")
    private Double allowance;

    // Deduction
    @NotNull(message = "Deduction is required")
    @PositiveOrZero(message = "Deduction cannot be negative")
    private Double deduction;

    // Net salary
    private Double netSalary;

    // Payment date
    private LocalDate paymentDate;

    // Payroll status
    @NotBlank(message = "Payroll status is required")
    private String status;
}
