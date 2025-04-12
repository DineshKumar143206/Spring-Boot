package com.validate.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Login {
	
	@NotBlank(message = "username cannot be empty !!!")
	@Size(min = 4, max = 15, message = "username must be between 4-15 characters")
	private String name;
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Login - name = " + name + ", email = " + email;
	}
	
	

}
