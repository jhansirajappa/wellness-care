package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ty.wellness_care.dao.UserDao;
import com.ty.wellness_care.dto.Admin;
import com.ty.wellness_care.dto.User;
import com.ty.wellness_care.service.UserService;
import com.ty.wellness_care.util.PasswordAES;
import com.ty.wellness_care.util.ResponseStructure;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		user.setPassword(PasswordAES.encrypt(user.getPassword()));
		User user2=userDao.saveUser(user);
		user2.setPassword(PasswordAES.decrypt(user2.getPassword()));
		if(user2!=null) {
		ResponseStructure<User> structure = new ResponseStructure<User>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("successful");
		structure.setData(user2);
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(structure,
				HttpStatus.OK);
		return responseEntity;
	}
		return null;}

	@Override
	public ResponseEntity<ResponseStructure<User>> getUserById(int userId) {
		User user = userDao.getUserById(userId);
		if (user != null) {
			user.setPassword(PasswordAES.decrypt(user.getPassword()));
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
			for (User user : users) {
				user.setPassword(PasswordAES.decrypt(user.getPassword()));
			}
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("successful");
			structure.setData(users);
			ResponseEntity<ResponseStructure<List<User>>> reponseEntity = new ResponseEntity<ResponseStructure<List<User>>>(
					structure, HttpStatus.OK);

			return reponseEntity;
		}
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user, @PathVariable int userId) {
		User userid = userDao.updateUser(userId, user);
		if (userid != null) {
//			user.setPassword(PasswordAES.encrypt(user.getPassword()));
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
