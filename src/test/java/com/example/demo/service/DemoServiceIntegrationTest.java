package com.example.demo.service;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Demo;
import com.example.demo.repository.DemoRepository;
import com.example.demo.services.DemoService;
import com.example.demo.services.DemoServiceImpl;

@RunWith(SpringRunner.class)
public class DemoServiceIntegrationTest {
	
	@TestConfiguration
	static class DemoServiceImplTestContextConfiguration {
		
		@Bean
		public DemoService demoService() {
			return new DemoServiceImpl();
		}
	}
	
	@Autowired
	private DemoService demoService;
	
	
	@MockBean
	private DemoRepository demoRepository;
	
	public void setUp() {
	
		Page<Demo> demoss = Mockito.mock(Page.class);		
		Mockito.when(demoRepository.findAll(org.mockito.Matchers.isA(Pageable.class))).thenReturn(demoss);
	}
	
	@Test
	public void whenvalidDemoThenDemoShouldBeFound() {
		
		Page<Demo> demos= demoService.getAllDemos(0, 10);
		assertNull(demos);	
	}
}
