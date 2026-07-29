package in.strikes.HRMS.entity;



import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "hr")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HR {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    @Column(unique = true)
    private String email;


    private String password;


}
