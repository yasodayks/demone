package com.example.demo.utils;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomFilter extends GenericFilterBean{	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		
		String uri = req.getRequestURI();
		if(!StringUtils.isEmpty(uri) && uri.equals("/sign-up")) {
			chain.doFilter(request, response);
		}else {
			String authrorizationHeader=req.getHeader("authorization");	
			   if(Objects.isNull(authrorizationHeader)) {
				   
			   }else if(Objects.nonNull(authrorizationHeader) || authrorizationHeader.startsWith(SecurityUtils.TOKEN_PREFIX)) {
					
					boolean flag=JwtTokenUtil.verifyJwtToken(authrorizationHeader);
					if(flag) {
					 chain.doFilter(request, response);
					}else {
						log.error("401 unauthorized");
					}
				
			}
		}
	
	}
	
		
		
	
}
