package com.example.demo.utils;

import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {
	
	private static final String SECRET_KEY = "torcher";

	
	public static String generateToken() {
		JwtBuilder builder = Jwts.builder()
				.setId("demo")
				.setSubject("demo")
				.setIssuer("demo")
	            .setIssuedAt(new Date(System.currentTimeMillis()))	            
	            .signWith(SignatureAlgorithm.HS256, 
	            		new SecretKeySpec(DatatypeConverter.parseBase64Binary(SECRET_KEY), 
	            				SignatureAlgorithm.HS256.getJcaName()));
		return builder.compact();
	}	
	
	
	public static boolean verifyJwtToken(String jwt) {	    
		try {
	    Claims claims = Jwts.parser()
	            .setSigningKey(DatatypeConverter.parseBase64Binary("torcher"))
	            .parseClaimsJws(jwt.replace(SecurityUtils.TOKEN_PREFIX, "")).getBody();
	    if(!claims.isEmpty() && claims.getSubject().equals("demo")) {
	    	return Boolean.TRUE;
	    }
		}catch (Exception e) {
			e.getStackTrace();
		}
		return false;
	    
	}
	
	
	
	
}
