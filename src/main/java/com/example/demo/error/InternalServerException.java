package com.example.demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InternalServerException() {
		super();
	}
	
	public InternalServerException(String message) {
		super(message);
	}
	
	public InternalServerException(String message, Throwable t) {
		super(message, t);
	}

}
