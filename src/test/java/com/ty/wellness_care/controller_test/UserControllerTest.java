package com.ty.wellness_care.controller_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ty.wellness_care.controller.UserController;
import com.ty.wellness_care.dao.UserDao;
import com.ty.wellness_care.dto.User;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserControllerTest {

	@Autowired
	private UserController controller;

	@MockBean
	private UserDao dao;

	@Test
	public void saveUserTest() {

		User user = new User();
		when(dao.saveUser(user)).thenReturn(user);
		assertEquals(user, controller.saveUser(user).getBody().getData());
	}

	@Test
	public void getUserByIdTest() {

		User user = new User();
		when(dao.getUserById(1)).thenReturn(user);
		assertEquals(user, controller.getUserById(1).getBody().getData());

	}

	@Test
	public void getAllUsersTest() {
		List<User> users = new ArrayList<User>();
		User user1 = new User();
		User user2 = new User();
		User user3 = new User();

		users.add(user1);
		users.add(user2);
		users.add(user3);

		when(dao.getAllUsers()).thenReturn(users);
		assertEquals(3, controller.getAllUsers().getBody().getData().size());
	}

	@Test
	public void updateUserTest() {

		User user = new User();
		when(dao.updateUser(1, user)).thenReturn(user);
		assertEquals(user, controller.upddateUser(user, 1).getBody().getData());
	}

	@Test
	public void deleteUserTest() {

		boolean b = true;
		String del = "User deleted";
		when(dao.deleteUser(1)).thenReturn(b);
		assertEquals(del, controller.deleteUser(1).getBody().getData());

	}

}
