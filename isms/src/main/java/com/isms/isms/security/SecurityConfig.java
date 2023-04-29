package com.isms.isms.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    // add support for JDBC
    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource){

        return new JdbcUserDetailsManager(dataSource);
    }


    // restricting access based on roles
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/students").hasRole("PROFESSOR")
                        .requestMatchers(HttpMethod.GET, "/api/students").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/students/**").hasRole("PROFESSOR")
                        .requestMatchers(HttpMethod.GET, "/api/students/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/students").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/students").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/students/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/professors").hasRole("PROFESSOR")
                        .requestMatchers(HttpMethod.GET, "/api/professors").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/professors/**").hasRole("PROFESSOR")
                        .requestMatchers(HttpMethod.GET, "/api/professors/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/professors").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/professors").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/professors/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/courses").hasRole("PROFESSOR")
                        .requestMatchers(HttpMethod.GET, "/api/courses").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/courses").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/courses/**").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/courses/**").hasRole("PROFESSOR")
                        .requestMatchers(HttpMethod.GET, "/api/courses/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/courses").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/courses").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/courses/**").hasRole("ADMIN")



        );

        // use HTTP Basic authentication
        httpSecurity.httpBasic();

        // disable Cross site request forgery (CSRF)
        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }

}
