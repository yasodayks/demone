package com.example.demo.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO implements Serializable{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String token;
}
