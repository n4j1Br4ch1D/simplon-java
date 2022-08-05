package com.stackabuse.hibernatedemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private DataSource dataSource;
  
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/signin").permitAll()
            .antMatchers("/dashboard/**").hasAuthority("admin")
            .and().formLogin().loginPage("/signin").permitAll()
           .defaultSuccessUrl("/dashboard/users").failureUrl("/signin?error=true").and().logout().logoutUrl("/signout").logoutSuccessUrl("/signin");
// https://www.baeldung.com/spring-security-manual-logout
}
   

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select email as principal, password as credentails, true from users where email=? and role='admin'")
                .authoritiesByUsernameQuery("select email as principal, role as role from users where email=?");
//                .passwordEncoder(passwordEncoder());
    }
  
    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
    return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
  
  
 
}