package com.ty.wellness_care.exception;

public class DeleteUserException extends RuntimeException{
	String message="Cannot delete the User without deleting the Appointment and Medorders";

	public DeleteUserException(String message) {
		this.message = message;
	}

	public DeleteUserException() {
		super();
	}
	
	@Override
	public String getMessage() {
		return message;
	}

}
