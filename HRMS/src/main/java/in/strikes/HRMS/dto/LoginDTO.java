package in.strikes.HRMS.dto;




import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {


    @Email(message = "Invalid email")
    @NotBlank(message = "Email required")
    private String email;



    @NotBlank(message = "Password required")
    private String password;


}
