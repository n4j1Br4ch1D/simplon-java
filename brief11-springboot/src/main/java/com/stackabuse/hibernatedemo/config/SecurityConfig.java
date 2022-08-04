package com.stackabuse.hibernatedemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private DataSource dataSource;
  
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/signin").permitAll()  //, "resources/static/**"
            .antMatchers("/dashboard/**").hasAnyRole("admin")
            .and().formLogin().loginPage("/signin").permitAll()
           .defaultSuccessUrl("/dashboard/users").and().logout().logoutSuccessUrl("/signout");
}
   

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select email as principal, password as credentails, true from member where email=?")
                .authoritiesByUsernameQuery("select email as principal, role as role from role where email=?");
//                .passwordEncoder(passwordEncoder()).rolePrefix("ROLE_");
    }
  
  
  
 
}