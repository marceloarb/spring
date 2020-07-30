package com.teksystems.TekcampExerciseSpring.Services;



import java.util.Optional;

import com.teksystems.TekcampExerciseSpring.Models.UserEntity;
import com.teksystems.TekcampExerciseSpring.Models.Response.UserResponse;
import com.teksystems.TekcampExerciseSpring.Shared.Dto.UserDto;


public interface UserService {
	UserDto createUser(UserDto userDto);
	Iterable<UserEntity> displayUsers(int page, int limit);
	void deleteUser(Long id);
	Optional<UserEntity> findById(Long id);
	Optional<UserEntity> getUserByEmail(String email);
	UserResponse updateUser(UserEntity userEntity);


}
