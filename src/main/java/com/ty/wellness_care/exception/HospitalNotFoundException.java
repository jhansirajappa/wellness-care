package com.ty.wellness_care.exception;

public class HospitalNotFoundException extends RuntimeException{

	String message="User Not Found";

	public HospitalNotFoundException(String message) {
		this.message = message;
	}

	public HospitalNotFoundException() {
		super();
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	

	
}
