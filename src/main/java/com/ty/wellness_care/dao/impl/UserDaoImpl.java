package com.ty.wellness_care.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.wellness_care.dao.UserDao;
import com.ty.wellness_care.dto.User;
import com.ty.wellness_care.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	UserRepository userRepository;

	public User saveUser(User user) {
		User userrepo = userRepository.save(user);
		return userrepo;
	}

	@Override
	public User getUserById(int id) {
		Optional<User> users = userRepository.findById(id);
		if (users.isPresent()) {
			return users.get();

		} else
			return null;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User updateUser(int id, User user) {
		User existingUser = getUserById(id);

		if (existingUser != null) {
			existingUser.setUserId(user.getUserId());
			existingUser.setName(user.getName());
			existingUser.setEmail(user.getEmail());
			existingUser.setPassword(user.getPassword());
			existingUser.setPhone_no(user.getPhone_no());
			return userRepository.save(existingUser);
		} else {
			return null;
		}
	}

	public boolean deleteUser(int id) {
		User user = getUserById(id);
		if (user != null) {
			userRepository.delete(user);
			return true;
		} else
			return false;

	}

	@Override
	public User validateUser(String email, String password) {
		return userRepository.validateUser(email, password);
	}

}
