package com.example.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.model.Demo;
import com.example.demo.repository.DemoRepository;

@Service
public class DemoServiceImpl implements DemoService{
	
	@Autowired
	private DemoRepository demoRepository;
	
	public Page<Demo> getAllDemos(PageRequest pageRequest){
		return demoRepository.findAll(pageRequest);
	}
	
	public void saveDemo(Demo demo){
		demoRepository.save(demo);
	}
	
	
	public void updateDemo(String desc, String name, int id) {
		demoRepository.setDemo(desc, name,id);
	}

	@Override
	public void deleteDemo(int id) {
		demoRepository.deleteById(id);		
	}

}
