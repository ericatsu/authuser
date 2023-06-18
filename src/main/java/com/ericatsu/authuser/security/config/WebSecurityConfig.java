package com.ericatsu.authuser.security.config;

import org.hibernate.jdbc.Expectations;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {
    
    @Override
    protected void configure(HttpSecurity http) throws Expectations {
        super.configure(http);
    }
    
}
