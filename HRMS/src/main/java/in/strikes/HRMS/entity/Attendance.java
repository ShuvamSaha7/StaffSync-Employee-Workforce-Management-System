package in.strikes.HRMS.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "attendance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Employee who attended
    @NotNull(message = "Employee is required")
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    // Attendance date
    @NotNull(message = "Attendance date is required")
    private LocalDate attendanceDate;

    // Check-in time
    private LocalTime checkIn;

    // Check-out time
    private LocalTime checkOut;

    // PRESENT / ABSENT / HALF DAY
    @NotNull(message = "Attendance status is required")
    private String status;

    // Optional remarks
    private String remarks;
}
