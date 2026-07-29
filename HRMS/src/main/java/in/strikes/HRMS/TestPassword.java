package in.strikes.HRMS;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPassword {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder =
                new BCryptPasswordEncoder();

        String hash =
                "$2a$10$2gCYZFeqhdnN1crv9CUBdOhVAw2Ci2XAeee5YVZR2YeNwB2CvWXw6";

        System.out.println(
                encoder.matches("12345", hash)
        );

    }
}