package com.example.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.services.DemoService;
import com.example.demo.utils.JwtTokenUtil;

@RunWith(SpringRunner.class)
@WebMvcTest
public class DemoControllerTest {	
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DemoService demoService;	
	
	@Test
	public void getDemosTest() throws Exception {
		String token = JwtTokenUtil.generateToken();
		mockMvc.perform(MockMvcRequestBuilders.get("/demos").param("page", "0").param("size", "10")
				.header(HttpHeaders.AUTHORIZATION, "Bearer " + token)).andExpect(MockMvcResultMatchers.status().isOk());

	}
	

}
