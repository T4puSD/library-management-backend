package com.tapusd.librarymanagement.config;

import com.tapusd.librarymanagement.domain.enumeration.Role;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
    private static final String H2_CONSOLE_ANT_MATCHER = "/h2-console/**";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").roles("ADMIN").password("password");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers()
                    .frameOptions().sameOrigin()
                .and()
                .csrf()
                .ignoringAntMatchers(H2_CONSOLE_ANT_MATCHER)
                .disable()
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole(Role.ADMIN.name())
                .antMatchers("/user/**").hasAnyRole(Role.ADMIN.name(), Role.STUDENT.name(), Role.FACULTY.name())
                .antMatchers(H2_CONSOLE_ANT_MATCHER).permitAll()
                .anyRequest().permitAll();
    }
}
