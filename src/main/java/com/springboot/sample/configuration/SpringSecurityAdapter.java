package com.springboot.sample.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("topic")
                .password("password")
                .roles("TOPIC")
                .and()
                .withUser("jpacourse")
                .password("password")
                .roles("JPACOURSE")
                .and()
                .withUser("course")
                .password("password")
                .roles("COURSE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/rest/topic/**")
                .hasRole("TOPIC")
                .antMatchers("/rest/courses", "/rest/course/*", "/rest/course")
                .hasRole("COURSE")
                .antMatchers("/jpa/courses", "/jpa/course/*", "/jpa/course")
                .hasRole("JPACOURSE")
                .antMatchers( "/")
                .hasAnyRole("TOPIC", "COURSE", "JPACOURSE")
                .antMatchers("/images/**", "/error")
                .permitAll()
                .and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
