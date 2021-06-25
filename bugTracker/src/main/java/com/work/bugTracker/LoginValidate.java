package com.work.bugTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class LoginValidate extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsService authService;
    @Autowired
    private CustomLoginHandler custHandler;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin").hasRole("admin")
                .antMatchers("/tester").hasRole("tester")
                .antMatchers("/addUser").hasRole("admin")
                .antMatchers("/addbug").hasAnyRole("admin", "tester")
                .and()
                .formLogin()
                .loginPage("/login.html")
                //.defaultSuccessUrl("/index", true)
                .successHandler(custHandler)
                .failureUrl("/login-error.html");

        //to access from postman
//                .and()
//                .csrf().disable();


//        http.authorizeRequests()
//                .antMatchers("/admin").hasRole("admin")
//                .antMatchers("/user").hasRole("tester")
//                .antMatchers("/").permitAll().and().formLogin();
    }

    //not sure
    @Bean
    public PasswordEncoder getPasswordEncode()
    {
        return NoOpPasswordEncoder.getInstance();
    }
}
