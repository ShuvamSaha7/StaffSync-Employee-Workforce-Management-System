package in.strikes.HRMS.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {


        http

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(
                                "/login",
                                "/css/**"
                        ).permitAll()

                        .anyRequest().authenticated()

                )


                .formLogin(login -> login

                        .loginPage("/login")

                        .defaultSuccessUrl("/dashboard", true)

                        .permitAll()

                )


                .logout(logout -> logout

                        .logoutUrl("/logout")

                        .logoutSuccessUrl("/login?logout")

                        .invalidateHttpSession(true)

                        .clearAuthentication(true)

                        .permitAll()

                );


        return http.build();

    }


}