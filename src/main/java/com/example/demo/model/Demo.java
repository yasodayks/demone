package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="demo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Demo {
	
	@Id	
	private int id;
	
	@Column(name = "demoname")
	private String demoname;
	
	@Column(name = "demodesc")
	private String demodesc;	

}
