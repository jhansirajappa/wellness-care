package com.ty.wellness_care.controller_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ty.wellness_care.controller.MedOrderController;
import com.ty.wellness_care.controller.UserController;
import com.ty.wellness_care.dao.MedOrderDao;
import com.ty.wellness_care.dao.UserDao;
import com.ty.wellness_care.dto.MedOrder;
import com.ty.wellness_care.dto.User;


@RunWith(SpringRunner.class)
@SpringBootApplication
public class MedOrderControllerTest {
	@Autowired
	private MedOrderController controller;

	@MockBean
	private MedOrderDao dao;

	@Test
	public void saveMedOrderTest() {

		MedOrder medOrder = new MedOrder();
		when(dao.saveMedOrder(medOrder)).thenReturn(medOrder);
		assertEquals(medOrder, controller.saveMedOrder(medOrder).getBody().getData());
	}
	/*
	 * @Test public void getUserByIdTest() {
	 * 
	 * User user = new User(); when(dao.getUserById(1)).thenReturn(user);
	 * assertEquals(user, controller.getUserById(1).getBody().getData());
	 * 
	 * }
	 * 
	 * @Test public void getAllUsersTest() { List<User> users = new
	 * ArrayList<User>(); User user1 = new User(); User user2 = new User(); User
	 * user3 = new User();
	 * 
	 * users.add(user1); users.add(user2); users.add(user3);
	 * 
	 * when(dao.getAllUsers()).thenReturn(users); assertEquals(3,
	 * controller.getAllUsers().getBody().getData().size()); }
	 * 
	 * @Test public void updateUserTest() {
	 * 
	 * User user = new User(); when(dao.updateUser(1, user)).thenReturn(user);
	 * assertEquals(user, controller.upddateUser(user, 1).getBody().getData()); }
	 * 
	 * @Test public void deleteUserTest() {
	 * 
	 * boolean b = true; String del = "User deleted";
	 * when(dao.deleteUser(1)).thenReturn(b); assertEquals(del,
	 * controller.deleteUser(1).getBody().getData());
	 * 
	 * }
	 * 
	 */}
