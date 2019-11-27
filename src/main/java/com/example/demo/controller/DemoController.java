package com.example.demo.controller;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Demo;
import com.example.demo.model.TokenDTO;
import com.example.demo.services.DemoService;
import com.example.demo.utils.JwtTokenUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/demone")
@Api
@Slf4j
public class DemoController {
	
	@Autowired
	private DemoService demoService;	
	
	@PostMapping(path="/sign-up")	
	@ResponseBody TokenDTO signUp() {
		return new TokenDTO(JwtTokenUtil.generateToken());
    }
	
	
	@GetMapping(path = "/demos", params = {"page", "size" })
	@ApiOperation(value = "get demos from database",
            notes = "get demos from database")
	@ApiResponses({
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 404, message = "Resource does not exists")
    })
	Page<Demo> getDemos(@PathParam("page") int page, 
			@PathParam("size") int size) {		
		return demoService.getAllDemos(page,size);		
	}
	
	@PostMapping(path="/saveDemo", produces = "application/json", consumes = "application/json")	
	@ApiOperation(value = "save demo into database",
    notes = "save demo into database")
	@ApiResponses({
	@ApiResponse(code = 200, message = "Success"),
	@ApiResponse(code = 400, message = "Bad Request"),
	@ApiResponse(code = 404, message = "Resource does not exists")
	})
	void saveDemos(@RequestBody Demo demo) {
		demoService.saveDemo(demo);
		log.info("successfully saved demo record into database");
	}
	 
	@PutMapping(path = "/{id}")
	@ApiOperation(value = "updates demo record in database",notes = "updates demo record in database")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Success"),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 404, message = "Resource does not exists")
	})
	void updateDemo(@PathVariable int id, @RequestBody Demo demo ) {
		demoService.updateDemo(demo.getDemodesc(), demo.getDemoname(),id);
	}
	
	@DeleteMapping(path ="/{id}")
	@ApiOperation(value = "Deletes demo record in database",notes = "Deletes demo record in database")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Success"),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 404, message = "Resource does not exists")
	})
	void deleteDemo(@PathVariable int id ) {
		demoService.deleteDemo(id);
	}

}
