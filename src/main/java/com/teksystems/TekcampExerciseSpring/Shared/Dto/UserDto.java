package com.teksystems.TekcampExerciseSpring.Shared.Dto;


public class UserDto {
	
	 private Long id;
	 private String userId;
		private String firstName;
		private String lastName;
	    private String email;
	    private String password;
	    private String passwordConfirmation;
	    private boolean duplicate;
	    public UserDto() {
	    	
	    }
		public UserDto( String userId, String firstName, String lastName, String email, String password,
				String passwordConfirmation, boolean duplicate) {
			this.userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.password = password;
			this.passwordConfirmation = passwordConfirmation;
			this.duplicate = duplicate;
		}
		
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
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
		public boolean isDuplicate() {
			return duplicate;
		}
		public void setDuplicate(boolean duplicate) {
			this.duplicate = duplicate;
		}
		@Override
		public String toString() {
			return "UserDto [id=" + id + ", userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", email=" + email + ", password=" + password + ", passwordConfirmation=" + passwordConfirmation
					+ ", duplicate=" + duplicate + "]";
		}
		
	    
	    
}
