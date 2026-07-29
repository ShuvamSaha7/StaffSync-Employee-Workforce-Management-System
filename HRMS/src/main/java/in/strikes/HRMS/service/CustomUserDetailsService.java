package in.strikes.HRMS.service;




import in.strikes.HRMS.entity.HR;
import in.strikes.HRMS.repository.HRRepository;

import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.stereotype.Service;

import java.util.Collections;



@Service
public class CustomUserDetailsService
        implements UserDetailsService {



    private final HRRepository hrRepository;



    public CustomUserDetailsService(HRRepository hrRepository) {

        this.hrRepository = hrRepository;

    }





    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {



        HR hr = hrRepository.findByEmail(email)

                .orElseThrow(() ->

                        new UsernameNotFoundException(
                                "HR user not found"
                        )

                );




        return new User(

                hr.getEmail(),

                hr.getPassword(),

                Collections.singleton(

                        new SimpleGrantedAuthority(
                                "ROLE_HR"
                        )

                )

        );


    }

}