package com.example.CrudAppSecurBoor.config;

import com.example.CrudAppSecurBoor.config.handler.SuccessHandler;
import com.example.CrudAppSecurBoor.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

    private final UserDetailServiceImpl userDetailService;
    private final SuccessHandler successHandler;

    @Autowired
    public Security(@Qualifier("UserDetailServiceImpl") UserDetailServiceImpl userDetailService
            , SuccessHandler successHandler) {
        this.userDetailService = userDetailService;
        this.successHandler = successHandler;
    }

    @Override
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }


    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
/*
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").access("hasAnyRole ('ROLE_ADMIN','ROLE_USER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/users/**").access("hasAnyRole ('ROLE_ADMIN','ROLE_USER')")




    }*/
@Override
protected void configure(HttpSecurity http) throws Exception {
    http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/").access("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
            .antMatchers("/auth/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
            .antMatchers("/users/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
            .antMatchers("/admins/**").access("hasRole('ROLE_ADMIN')")
            .antMatchers("/login/**", "/registration/**").anonymous()
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/login")
            .usernameParameter("j_email")
            .passwordParameter("j_password")
            .successHandler(successHandler)
            .permitAll()
            .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login")
            .permitAll();
}

}