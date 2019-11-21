package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Demo;
import com.example.demo.repository.DemoRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@DataJpaTest
@Slf4j
public class DemoControllerTest {
	
	@Autowired
	private DemoRepository demoRepository;
	
	@Autowired
	private DataSource datasource;
    
	@Test
	public void testFindAllDemos() {
		Demo demo = new Demo();
		demo.setId(123);
		demo.setDemoname("Yash");
		demo.setDemodesc("Yash");
		demoRepository.save(demo);
		List<Demo> demos=demoRepository.findAll();
		log.info("datasource: {}",datasource);
		log.info("demos.size(): {}",demos.size());
		assertEquals(demos.size(), 1);
		assertEquals(demo, demos.get(0));
	}
	
}
