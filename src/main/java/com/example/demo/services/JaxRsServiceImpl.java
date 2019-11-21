package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.JaxRsModel;
import com.example.demo.repository.JaxRsRepository;

@Service
public class JaxRsServiceImpl implements JaxRsService{

	@Autowired
	private JaxRsRepository jaxRsRepository;
	
	public void saveJaxRs(JaxRsModel model){
		jaxRsRepository.save(model);
	}
}
