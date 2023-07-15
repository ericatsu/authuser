package com.ericatsu.authuser.security;

import org.hibernate.jdbc.Expectations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class UserRegistrationSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 1:40:42
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.cors(withDefaults())
        .csrf(csrf -> csrf.disable())
                .authorizeHttpRequest()
                .requestMatchers("/register")
                .permitAll()
                .and()
                .authorizeHttpRequest()
                .requestMatchers("/users")
                .hasAnyAuthority("USER", "ADMIN")
                .and()
                .fromLogin()
                .and()
                .build();
    }
}
