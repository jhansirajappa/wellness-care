package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ty.wellness_care.dao.UserDao;
import com.ty.wellness_care.dto.User;
import com.ty.wellness_care.service.UserService;
import com.ty.wellness_care.util.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<User>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("successful");
		structure.setData(userDao.saveUser(user));
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(structure,
				HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<User>> getUserById(int userId) {
		User user = userDao.getUserById(userId);
		if (user != null) {
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("successfull");
			structure.setData(user);
			ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(
					structure, HttpStatus.OK);

			return responseEntity;
		} else {
			return null;
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<User>>> getAllUsers() {
		List<User> users = userDao.getAllUsers();
		ResponseStructure<List<User>> structure = new ResponseStructure<List<User>>();

		if (users != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("successful");
			structure.setData(users);
			ResponseEntity<ResponseStructure<List<User>>> reponseEntity = new ResponseEntity<ResponseStructure<List<User>>>(
					structure, HttpStatus.OK);

			return reponseEntity;
		} else {
			return null;
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user, @PathVariable int userId) {
		User userid = userDao.updateUser(userId, user);
		if (userid != null) {
			ResponseStructure<User> structure = new ResponseStructure<User>();
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("successful");
			structure.setData(userid);
			ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(
					structure, HttpStatus.OK);
			return responseEntity;

		} else {
			return null;
		}

	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteUser(int userId) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity;

		if (userDao.deleteUser(userId)) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("successful");
			structure.setData("User deleted");
			responseEntity = new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
			return responseEntity;
		} else {
			return null;
		}

	}

}
