package com.teksystems.TekcampExerciseSpring.Service.Implementation;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.teksystems.TekcampExerciseSpring.Models.UserEntity;
import com.teksystems.TekcampExerciseSpring.Models.Response.UserResponse;
import com.teksystems.TekcampExerciseSpring.Repositories.UserRepository;
import com.teksystems.TekcampExerciseSpring.Services.UserService;
import com.teksystems.TekcampExerciseSpring.Shared.Dto.UserDto;
import com.teksystems.TekcampExerciseSpring.SharedUserId.SharedUserId;

@Service
public class UserServiceImplementation implements UserService{
	private SharedUserId sharedUserId;
	
	public UserServiceImplementation(SharedUserId sharedUserId) {
		this.sharedUserId = sharedUserId;
	}
	@Autowired
	private  UserRepository userRepository;
	
	
	@Override 
	public UserDto createUser(UserDto userDto) {
		
		UserEntity newUser = new UserEntity();
		BeanUtils.copyProperties(userDto, newUser);
		
		newUser.setUserId(sharedUserId.generateUserId(30));
		UserEntity storedUserDetails = userRepository.save(newUser);
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		
		return returnValue;
	}



	@Override
	public Iterable<UserEntity> displayUsers(int page, int limit) {
		if (page>0) page --;
		PageRequest pageableRequest = PageRequest.of(page,  limit);
		Page<UserEntity> userPage = userRepository.findAll(pageableRequest);
		Iterable<UserEntity> returnValue = userPage.getContent();
		return returnValue;
	}



	@Override
	public void deleteUser(Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
		
	}



	@Override
	public Optional<UserEntity> findById(Long userId) {
		return userRepository.findById(userId);
		
	}



	@Override
	public Optional<UserEntity> getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}



	@Override
	public UserResponse updateUser(UserEntity userEntity) {
		UserResponse currentUser = new UserResponse();
		if(userRepository.findById(userEntity.getId()).isPresent()) {
			System.out.println(userEntity);
			userRepository.save(userEntity);
			BeanUtils.copyProperties(userEntity, currentUser);
			return currentUser;
		}
		
		return null;
		
	}

	


}
