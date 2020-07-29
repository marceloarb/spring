package com.teksystems.TekcampExerciseSpring.Models.Request;


public class UserRequest {
	
	private String firstName;
	private String lastName;
    private String email;
    private String password;
    private String passwordConfirmation;
    
	public UserRequest(String firstName, String lastName, String email, String password,String passwordConfirmation) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
	}
    
	public UserRequest() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	@Override
	public String toString() {
		return "UserRequest [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", passwordConfirmation=" + passwordConfirmation + "]";
	}
    
    
    
    
}
