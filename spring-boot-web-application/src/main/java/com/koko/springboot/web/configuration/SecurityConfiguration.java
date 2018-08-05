package com.koko.springboot.web.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
		UserDetails userDetails=User.withUsername("vivaan").password("{noop}dummy").roles("USER").build();

        auth.inMemoryAuthentication().withUser(userDetails)
        	.withUser(User.withUsername("sandeep").password("{noop}dummy").roles("USER").build());
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login").permitAll()
                .antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
                .formLogin();
    }
}