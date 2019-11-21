package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="jaxrsmodel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JaxRsModel {
	
	@Id
	private int id;
	
	@Column(name="methodname")
	private String methodName;
	
	@Column(name="description")
	private String description;

}
