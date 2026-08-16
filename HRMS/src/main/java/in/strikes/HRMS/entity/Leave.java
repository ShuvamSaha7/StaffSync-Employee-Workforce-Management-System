package in.strikes.HRMS.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "leaves")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // Employee taking the leave

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;


    // Leave type

    @NotBlank(message = "Leave type is required")
    private String leaveType;


    // Leave start date

    @NotNull(message = "Start date is required")
    private LocalDate startDate;


    // Leave end date

    @NotNull(message = "End date is required")
    private LocalDate endDate;


    // Reason

    @NotBlank(message = "Reason is required")
    @Column(length = 500)
    private String reason;


    // Leave status

    @NotBlank(message = "Status is required")
    private String status;

}