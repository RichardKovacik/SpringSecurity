package com.example.SpringLogin;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("riso")
                                     .password("$2a$10$HE2hht9TQPOGJXXqwKzMeOGvWFPOw.8hd1jCHWoJPv06nj9d6jJa6")
                                     .roles("USER")
                .and().withUser("admin")
                .password("$2a$10$XEB9bYlHPsh4.flEiUfXLOE6A2hk5aPvhJ39HJAkE3WadImLCDl.K")
                .roles("ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
    }
}
