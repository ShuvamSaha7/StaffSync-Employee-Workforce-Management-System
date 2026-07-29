package in.strikes.HRMS.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    private Long id;

    private String projectName;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private String status;

}