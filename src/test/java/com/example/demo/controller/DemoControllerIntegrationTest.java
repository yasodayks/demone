package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.services.DemoService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class DemoControllerIntegrationTest {	
	
	@Autowired
    private MockMvc mvc;
 
    @MockBean
    private DemoService demoService;

    @Test
    public void testGetDemosApi() throws Exception {
    	
    	mvc.perform(get("/demos")).andExpect(status().isOk());
    	
    }
    
    @Test
    public void testSaveDemoApi() throws Exception {
    	mvc.perform(post("/saveDemo")).andExpect(status().isOk());
    }
}
