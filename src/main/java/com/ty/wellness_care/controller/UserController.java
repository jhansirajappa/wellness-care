package com.ty.wellness_care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.wellness_care.dto.User;
import com.ty.wellness_care.service.UserService;
import com.ty.wellness_care.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@PostMapping("user")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@GetMapping("user/{userid}")
	public ResponseEntity<ResponseStructure<User>> getUserById(@PathVariable int userid) {
		return service.getUserById(userid);
	}

	@GetMapping("user")
	public ResponseEntity<ResponseStructure<List<User>>> getAllUsers() {
		return service.getAllUsers();
	}

	@PutMapping("user/{userid}")
	public ResponseEntity<ResponseStructure<User>> upddateUser(@RequestBody User user, @PathVariable int userid) {
		return service.updateUser(user, userid);

	}

	@DeleteMapping("user")
	public ResponseEntity<ResponseStructure<String>> deleteUser(@RequestParam int id) {
		return service.deleteUser(id);
	}

}
