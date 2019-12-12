package com.example.demo.error;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.extern.slf4j.Slf4j;

@Order(value = 0)
@RestControllerAdvice
@EnableWebMvc
@Slf4j
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleDataNotFoundException(DataNotFoundException de){
		ExceptionResponse exceptionResponse = new ExceptionResponse(de.getMessage(),ErrorCodes.DATA_NOTFOUND);
		log.info("Exception is: DataNotFoundException");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}
	
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<ExceptionResponse> handleAuthenticationException(AuthenticationException ae){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ae.getMessage(),ErrorCodes.AUTHENTICATION_ERROR);
		log.info("Exception is: AuthenticationException");
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exceptionResponse);
	}
	
	@ExceptionHandler(InternalServerException.class)
	public ResponseEntity<ExceptionResponse> handleInternalServerError(InternalServerException ise){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ise.getMessage(), ErrorCodes.UNKNOWN_ERROR);
		log.info("Exception is: InternalServerException");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
	}
	

}
