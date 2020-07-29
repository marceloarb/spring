package com.teksystems.TekcampExerciseSpring.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="users")
public class UserEntity {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	private String userId;
	private String firstName;
	private String lastName;
	@Column(unique = true)
    private String email;
    private String password;
    @Transient
    private String passwordConfirmation;
    private boolean duplicate;
    @Column(updatable=false)
	private Date createdAt;
    private Date updatedAt;
    
    public UserEntity() {
    	
    }
    
    
	public UserEntity(String firstname, String lastname, String email, String password, String passwordConfirmation) {
		this.firstName = firstname;
		this.lastName = lastname;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
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

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
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
		return "UserEntity [id=" + id + ", firstname=" + firstName + ", lastname=" + lastName + ", email=" + email
				+ ", password=" + password + ", passwordConfirmation=" + passwordConfirmation + ", duplicate="
				+ duplicate + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}


	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    
    }
}
