package com.ty.wellness_care.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.User;
import com.ty.wellness_care.util.ResponseStructure;


public interface UserService {
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user);

	public ResponseEntity<ResponseStructure<User>> getUserById(int userId);

	public ResponseEntity<ResponseStructure<List<User>>> getAllUsers();

	public ResponseEntity<ResponseStructure<User>> updateUser(User user, int userId);

	public ResponseEntity<ResponseStructure<String>> deleteUser(int userId);

}
