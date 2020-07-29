package com.teksystems.TekcampExerciseSpring.SharedUserId;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class SharedUserId {
	
	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXVZabcdefghijklmnopqrstuvwyz1234567890";
	
	public String generateUserId(int length) {
		return generateRandomString(length);
	}

	private String generateRandomString(int length) {
		StringBuilder returnValue = new StringBuilder(length);
		
		for(int i = 0; i<length; i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		return returnValue.toString();
	}

}
