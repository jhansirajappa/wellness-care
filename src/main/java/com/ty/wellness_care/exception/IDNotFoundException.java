package com.ty.wellness_care.exception;

public class IDNotFoundException extends RuntimeException {

	String message="User Not Found";

	public IDNotFoundException(String message) {
		this.message = message;
	}

	public IDNotFoundException() {
		super();
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	
}
