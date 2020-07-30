package com.teksystems.TekcampExerciseSpring.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.teksystems.TekcampExerciseSpring.Models.UserEntity;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity,Long>{
	
	
	List<UserEntity> deleteByUserId(Long userId);

	Optional<UserEntity> findByEmail(String email);

	Optional<UserEntity> findAllById(String userId);

	void deleteById(Class<? extends Optional> class1);

	
	
}
