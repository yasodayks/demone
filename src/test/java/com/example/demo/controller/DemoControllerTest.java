package com.example.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.model.Demo;
import com.example.demo.services.DemoService;
import com.example.demo.utils.JwtTokenUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringRunner.class)
@WebMvcTest
public class DemoControllerTest {	
	
	private String token = JwtTokenUtil.generateToken();
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DemoService demoService;	
	
	@Test
	public void getDemosTest() throws Exception {		
		mockMvc.perform(MockMvcRequestBuilders.get("/demos").param("page", "0").param("size", "10")
				.header(HttpHeaders.AUTHORIZATION, "Bearer " + token)).andExpect(MockMvcResultMatchers.status().isOk());

	}
	
	@Test
	public void saveDemoTest() throws Exception {
		Demo demo = new Demo();
		demo.setId(234);
		demo.setDemodesc("yash");
		demo.setDemoname("yash");
		mockMvc.perform(MockMvcRequestBuilders.post("/saveDemo").content(getObjectMapperString(demo))
				.header(HttpHeaders.AUTHORIZATION, "Bearer " + token).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void updateDemoTest() throws Exception {
		Demo demo = new Demo();
		demo.setId(234);
		demo.setDemodesc("gayu");
		demo.setDemoname("gayu");
		mockMvc.perform(MockMvcRequestBuilders.put("/{id}","234").content(getObjectMapperString(demo))
				.header(HttpHeaders.AUTHORIZATION, "Bearer " + token).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	
	}
	
	@Test
	public void deleteDemoTest() throws Exception {
		Demo demo = new Demo();
		demo.setId(234);
		mockMvc.perform(
				MockMvcRequestBuilders.delete("/{id}", "234").header(HttpHeaders.AUTHORIZATION, "Bearer " + token))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	public String getObjectMapperString(Demo demo) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		return ow.writeValueAsString(demo);
	}
	

}
