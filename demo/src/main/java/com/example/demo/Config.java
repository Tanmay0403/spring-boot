package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Config {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        var user1 = User.withUsername("admin")
                .password(encoder.encode("admin"))
                .roles("USER")
                .build();

       
        return new InMemoryUserDetailsManager(user1);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // disable CSRF for testing (don’t do this in production)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/employee/").permitAll() // secure your employee API
                .requestMatchers("/employee/listing").authenticated() // secure your employee API
                .anyRequest().permitAll()
            )
            .httpBasic();
        return http.build();
    }
}
