package com.example.demo.config;

import org.springframework.boot.actuate.autoconfigure.web.server.ManagementServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.example.demo.utils.CustomFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	 private final ManagementServerProperties managementServerProperties;
	 
	private static RequestMatcher allOf(RequestMatcher... requestMatchers) {
		return new AndRequestMatcher(requestMatchers);
	}

	private static RequestMatcher not(RequestMatcher requestMatcher) {
		return new NegatedRequestMatcher(requestMatcher);
	}

	 public WebSecurityConfig(ManagementServerProperties managementServerProperties) {
		this.managementServerProperties=managementServerProperties;
	}

	
	@Override
    protected void configure(HttpSecurity http) throws Exception 
    {
		
		  http .csrf().requireCsrfProtectionMatcher(allOf(CsrfFilter.DEFAULT_CSRF_MATCHER, not(accessingManagementPort())))
		  .ignoringAntMatchers("/actuator/**").and()
		  .authorizeRequests().antMatchers("/sign-up")
		  .permitAll()
		  .and().addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class)
		  .httpBasic();
		 
    }
	
	 private RequestMatcher accessingManagementPort() {
	        return httpServletRequest -> httpServletRequest.getLocalPort() == managementServerProperties.getPort();
	    }
 
}
