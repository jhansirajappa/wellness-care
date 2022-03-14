package com.ty.wellness_care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.wellness_care.dto.Login;
import com.ty.wellness_care.dto.User;
import com.ty.wellness_care.service.UserService;
import com.ty.wellness_care.util.ResponseStructure;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("user")
	@ApiResponses({ @ApiResponse(code = 200, message = "User Saved"),
			@ApiResponse(code = 404, message = "User not saved"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<ResponseStructure<User>> saveUser(@Validated @RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("user/{userid}")
	@ApiResponses({ @ApiResponse(code = 200, message = "user retrieved"),
			@ApiResponse(code = 404, message = "user not retrieved"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<ResponseStructure<User>> getUserById(@PathVariable int userid) {
		return userService.getUserById(userid);
	}

	@GetMapping("user")
	@ApiResponses({ @ApiResponse(code = 200, message = "user retrived"),
			@ApiResponse(code = 404, message = "user not retrieved"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<ResponseStructure<List<User>>> getAllUsers() {
		return userService.getAllUsers();
	}

	@PutMapping("user/{userid}")
	@ApiResponses({ @ApiResponse(code = 200, message = "user updated"),
			@ApiResponse(code = 404, message = "user not updated"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user, @PathVariable int userid) {
		return userService.updateUser(user, userid);

	}

	@PostMapping("userlogin")
	@ApiResponses({ @ApiResponse(code = 200, message = "User Validation"),
			@ApiResponse(code = 404, message = "ID not found"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<ResponseStructure<User>> validateUser(@RequestBody Login login) {
		return userService.validateUser(login);
	}

	@DeleteMapping("user")
	@ApiResponses({ @ApiResponse(code = 200, message = "user deleted"),
			@ApiResponse(code = 404, message = "user not deleted"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<ResponseStructure<String>> deleteUser(@RequestParam int id) {
		return userService.deleteUser(id);
	}

}
