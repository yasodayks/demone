package com.example.demo.services;

import org.springframework.data.domain.Page;

import com.example.demo.model.Demo;

public interface DemoService {

	public Page<Demo> getAllDemos(int page,int size);
	public void saveDemo(Demo demo);
	public void updateDemo(String desc, String name, int id);
}
