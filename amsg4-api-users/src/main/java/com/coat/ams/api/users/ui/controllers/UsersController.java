package com.coat.ams.api.users.ui.controllers;

 import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coat.ams.api.users.service.*;
import com.coat.ams.api.users.shared.*;
import com.coat.ams.api.users.ui.model.CreateUserRequestModel;
import com.coat.ams.api.users.ui.model.CreateUserResponseModel;
import com.coat.ams.api.users.ui.model.UserResponseModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	UsersService usersService;

	@GetMapping("/status/check")
	public String status()
	{
		return "Working on port " + env.getProperty("local.server.port") + ", with token = " + env.getProperty("token.secret");
	}
 
	@GetMapping("/status/elk")
	public String elkCheck()
	{
		String response = "ELK TRUTHY logging..." + new Date();
		log.info(response);
		return response;
	}
 
	@GetMapping("/status/exception")
	public String elkException()
	{
		String response = "";
		try {
			throw new Exception("Exception has occurred...");
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.toString());
			
			StringWriter sw = new StringWriter();
			PrintWriter  pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			
			String stackTrace = sw.toString();
			log.error("Exception occurred - ", stackTrace);
			response = stackTrace;
		}
		
		return response;
	}
 
	@PostMapping(
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
			)
	public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails)
	{
		ModelMapper modelMapper = new ModelMapper(); 
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
		
		UserDto createdUser = usersService.createUser(userDto);
		
		CreateUserResponseModel returnValue = modelMapper.map(createdUser, CreateUserResponseModel.class);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}
	
    @GetMapping(value="/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserResponseModel> getUser(@PathVariable("userId") String userId) throws Exception {
       
        UserDto userDto = usersService.getUserByUserId(userId); 
        UserResponseModel returnValue = new ModelMapper().map(userDto, UserResponseModel.class);
        if(returnValue == null) {
        	throw new Exception("getUser Service is unavailable...");
        }
        
        log.error("getUser(@PathVariable(" + userId + ")", new Date());
        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }
	
	
}
