package in.strikes.HRMS.dto;




import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDTO {


    @NotBlank(message = "Name required")
    private String name;


    @NotBlank(message = "Email required")
    @Email(message = "Invalid email")
    private String email;


    @NotBlank(message = "Phone required")
    private String phone;


    @NotBlank(message = "Department required")
    private String department;


    @NotBlank(message = "Designation required")
    private String designation;


    @NotBlank(message = "Project required")
    private String project;


    @NotNull(message = "Salary required")
    @Positive
    private Double salary;


    private LocalDate joiningDate;


}