package com.teksystems.TekcampExerciseSpring.Service.Implementation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teksystems.TekcampExerciseSpring.Models.UserEntity;
import com.teksystems.TekcampExerciseSpring.Models.Response.UserResponse;
import com.teksystems.TekcampExerciseSpring.Repositories.UserRepository;
import com.teksystems.TekcampExerciseSpring.Services.UserService;
import com.teksystems.TekcampExerciseSpring.Shared.Dto.UserDto;
import com.teksystems.TekcampExerciseSpring.SharedUserId.SharedUserId;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	private  UserRepository userRepository;
	private SharedUserId sharedUserId;
	
	@Override 
	public UserDto createUser(UserDto userDto) {
		
		UserEntity newUser = new UserEntity();
		BeanUtils.copyProperties(userDto, newUser);
		
		newUser.setUserId("akjsdl;fajskdf");
		UserEntity storedUserDetails = userRepository.save(newUser);
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		
		return returnValue;
	}

	public Iterable<UserEntity> retrieveUsers() {
		
		return userRepository.findAll();
	}

	


}
