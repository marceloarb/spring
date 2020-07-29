package com.teksystems.TekcampExerciseSpring.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.teksystems.TekcampExerciseSpring.Models.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long>{

}
