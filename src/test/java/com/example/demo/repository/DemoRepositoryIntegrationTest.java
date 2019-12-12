package com.example.demo.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Demo;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@DataJpaTest
@Slf4j
public class DemoRepositoryIntegrationTest {
	
	@Autowired
	private DemoRepository demoRepository;
	
	@Autowired
	private DataSource datasource;
    
	@Test
	public void testFindAllDemos() {
		Demo demo = new Demo();
		demo.setId(1);
		demo.setDemoname("Yash");
		demo.setDemodesc("Yash");
		demoRepository.save(demo);
		Page<Demo> demos=demoRepository.findAll(PageRequest.of(0, 10));
		assertNotNull(demos);
	}
	
}
