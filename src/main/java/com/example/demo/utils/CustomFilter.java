package com.example.demo.utils;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import com.example.demo.error.ErrorCodes;
import com.example.demo.error.ExceptionResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomFilter extends GenericFilterBean{	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String uri = req.getRequestURI();
		if(!StringUtils.isEmpty(uri) && uri.equals("/demone/sign-up")) {
			chain.doFilter(request, response);
		}else {
			String authrorizationHeader=req.getHeader("authorization");	
			   if(Objects.isNull(authrorizationHeader)) {
				   //ExceptionResponse er = new ExceptionResponse("401 unauthorized", ErrorCodes.AUTHENTICATION_ERROR);
				   res.setContentType("application/json");
				   res.sendError(404, "check your previliges");
				   res.getWriter();			   
				   //log.error("401 unauthorized");
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
