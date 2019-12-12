package com.example.demo.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.demo.model.Demo;

public interface DemoService {

	public Page<Demo> getAllDemos(PageRequest pageRequest);
	public void saveDemo(Demo demo);
	public void updateDemo(String desc, String name, int id);
	public void deleteDemo(int id);
}
