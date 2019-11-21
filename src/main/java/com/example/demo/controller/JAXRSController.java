package com.example.demo.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.JaxRsModel;
import com.example.demo.services.JaxRsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/demone")
public class JAXRSController {

	@Autowired
	private JaxRsService jaxRsService;
	
	/*
	 * @POST
	 * 
	 * @Path("/saveJaxRs")
	 * 
	 * @Consumes("application/json")
	 * 
	 * @Produces("application/json")
	 */
	@PostMapping(path = "/saveJaxRs", produces = "application/json", consumes = "application/json")
	@ApiOperation(notes = "saving JaxRsModel",value = "saving JaxRsModel")
	@ApiResponses({
		@ApiResponse(code = 200 , message = "success"),
		@ApiResponse(code = 400 , message = "Bad Request"),
		@ApiResponse(code = 404 , message = "Resource Not Found")
		})
	void saveJaxRs(@RequestBody JaxRsModel model){
		jaxRsService.saveJaxRs(model);
	}
}
