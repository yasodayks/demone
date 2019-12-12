package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.example.demo.utils.CustomFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception 
    {		
		  http .csrf().disable()		  
		  .authorizeRequests().antMatchers("/sign-up")
		  .permitAll()
		  .and().addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class)
		  .httpBasic();		 
    }	
 
}
