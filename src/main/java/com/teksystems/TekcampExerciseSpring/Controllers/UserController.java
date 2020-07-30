package com.teksystems.TekcampExerciseSpring.Controllers;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teksystems.TekcampExerciseSpring.Models.UserEntity;
import com.teksystems.TekcampExerciseSpring.Models.Request.UserRequest;
import com.teksystems.TekcampExerciseSpring.Models.Response.UserResponse;
import com.teksystems.TekcampExerciseSpring.Services.UserService;
import com.teksystems.TekcampExerciseSpring.Shared.Dto.UserDto;
import com.teksystems.TekcampExerciseSpring.Validator.UserValidator;

@RestController
@RequestMapping(path = "users")
public class UserController {
	
	private final UserService userServ;
	
	public UserController(UserService userServ) {
		this.userServ = userServ;
	}
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping()
	public Iterable<UserEntity> displayUsers(
			@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="limit", defaultValue="5") int limit) {
		return userServ.displayUsers(page,limit);
	}
	@PostMapping( consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
					produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public UserResponse  createUser(@RequestBody UserRequest userRequest) {
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userRequest, userDto);
		
		UserDto createdUser = userServ.createUser(userDto);
		
		UserResponse returnValue = new UserResponse();
		BeanUtils.copyProperties(createdUser, returnValue);
		return returnValue;
	}
	@PutMapping( consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},path="/{userId}")
	public UserResponse updateUser(@RequestBody UserEntity userEntity) {
		return userServ.updateUser(userEntity);
	}
	
	@GetMapping(path="/{userId}")
	public Optional<UserEntity> displayUser(@PathVariable String userId) {
		Long id = Long.parseLong(userId);
		return userServ.findById(id);
	}
	
	@GetMapping(path="/email/{email}")
	public Optional<UserEntity> getUserByEmail(@PathVariable String email){
		return userServ.getUserByEmail(email);
	}
	
	@DeleteMapping(path="/{id}")
	public void deleteUser(@PathVariable Long id) {
		userServ.deleteUser(id);
	}
	
	

}
