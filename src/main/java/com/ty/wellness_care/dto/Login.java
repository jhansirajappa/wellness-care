package com.ty.wellness_care.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Login Entity", description = "Login Entity to hold Login Credentials")
public class Login {

	private String email;
	private String password;
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
	
	
}
