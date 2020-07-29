package com.teksystems.TekcampExerciseSpring.Controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teksystems.TekcampExerciseSpring.Models.UserEntity;
import com.teksystems.TekcampExerciseSpring.Models.Request.UserRequest;
import com.teksystems.TekcampExerciseSpring.Models.Response.UserResponse;
import com.teksystems.TekcampExerciseSpring.Service.Implementation.UserServiceImplementation;
import com.teksystems.TekcampExerciseSpring.Services.UserService;
import com.teksystems.TekcampExerciseSpring.Shared.Dto.UserDto;

@RestController
@RequestMapping(path = "users")
public class UserController {
	
	private final UserService userServ;
	private final UserServiceImplementation userServiceImplementation;
	
	public UserController(UserService userServ,UserServiceImplementation userServiceImplementation) {
		this.userServ = userServ;
		this.userServiceImplementation = userServiceImplementation;
	}
	
	@GetMapping()
	public Iterable<UserEntity> displayUsers() {
		return userServiceImplementation.retrieveUsers();
	}
	
	
	@PostMapping( consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
					produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public UserResponse  createUser(@RequestBody UserRequest userRequest) {
		System.out.println("From paramets" + userRequest.toString());
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userRequest, userDto);
		System.out.println("UserDto" + userDto.toString());
		
		UserDto createdUser = userServ.createUser(userDto);
		
		UserResponse returnValue = new UserResponse();
		BeanUtils.copyProperties(createdUser, returnValue);
		return returnValue;
	}
	

}
