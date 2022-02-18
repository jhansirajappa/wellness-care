package com.ty.wellness_care.dao;

import java.util.List;

import com.ty.wellness_care.dto.User;

public interface UserDao {

	User saveUser(User user);
	User updateUser(int id,User user);
	List<User> getAllUsers();
	boolean deleteUser(int id);
	User getUserById(int id);
}
