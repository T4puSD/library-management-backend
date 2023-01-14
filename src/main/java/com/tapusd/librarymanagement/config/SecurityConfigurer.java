package com.tapusd.librarymanagement.config;

import com.tapusd.librarymanagement.domain.enumeration.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {
    private static final String H2_CONSOLE_ANT_MATCHER = "/h2-console/**";

    @Bean
    public  UserDetailsService userDetailsService() {
        UserDetails student = User.withDefaultPasswordEncoder()
                .username("student")
                .password("password")
                .roles(Role.STUDENT.name())
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles(Role.ADMIN.name())
                .build();

        UserDetails facalty= User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles(Role.FACULTY.name())
                .build();

        return new InMemoryUserDetailsManager(student, admin, facalty);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .headers(headerConfig -> headerConfig.frameOptions().sameOrigin())
                .csrf(AbstractHttpConfigurer::disable)
                .cors()
                .and()
                .authorizeHttpRequests(req -> req
                        .requestMatchers("/admin/**").hasRole(Role.ADMIN.name())
                        .requestMatchers("/user/**").hasAnyRole(Role.ADMIN.name(),
                                Role.STUDENT.name(), Role.FACULTY.name())
                        .requestMatchers(H2_CONSOLE_ANT_MATCHER).permitAll()
                        .anyRequest().permitAll())
                .build();
    }
}
