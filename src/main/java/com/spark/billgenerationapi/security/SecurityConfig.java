package com.spark.billgenerationapi.security;

import com.spark.billgenerationapi.dto.Authority;
import com.spark.billgenerationapi.dto.Roles;
import com.spark.billgenerationapi.entity.Customer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return  httpSecurity.build();
    }


    @Bean
    public UserDetailsService userDetailsService()
    {
        UserDetails user1= User
                .withUsername("abhijeet")
                .password(passwordEncoder().encode("12345"))
                .authorities(Roles.ADMIN.getGrantedAuthority())
                .build();

        UserDetails user2=User.
                withUsername("sanket")
                .password(passwordEncoder().encode("12345"))
                .authorities(Roles.MANAGER.getGrantedAuthority())
                .build();


        UserDetails user3= User
                .withUsername("sankalp")
                .password(passwordEncoder().encode("12345"))
                .authorities(Roles.POS.getGrantedAuthority())
                .build();

        UserDetails user4=User.
                withUsername("ajay")
                .password(passwordEncoder().encode("12345"))
                .authorities(Roles.CUSTOMER.getGrantedAuthority())
                .build();

        InMemoryUserDetailsManager inMemoryUserDetailsManager=new InMemoryUserDetailsManager(user1,user2,user3,user4);
        return  inMemoryUserDetailsManager;
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder(10);
    }



}
