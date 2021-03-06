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

import com.ty.wellness_care.controller.AdminController;
import com.ty.wellness_care.dao.AdminDao;
import com.ty.wellness_care.dto.Admin;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminControllerTest {

	@Autowired
	private AdminController controller;

	@MockBean
	private AdminDao dao;

	@Test
	public void saveAdminTest() {

		Admin admin = new Admin();
		when(dao.saveAdmin(admin)).thenReturn(admin);
		assertEquals(admin, controller.saveAdmin(admin).getBody().getData());
	}

	@Test
	public void getAdminByIdTest() {

		Admin admin = new Admin();
		when(dao.getAdminById(1)).thenReturn(admin);
		assertEquals(admin, controller.getAdminById(1).getBody().getData());

	}

	@Test
	public void getAllAdminsTest() {
		List<Admin> admins = new ArrayList<Admin>();
		Admin admin1 = new Admin();
		Admin admin2 = new Admin();
		Admin admin3 = new Admin();
		admins.add(admin3);
		admins.add(admin2);
		admins.add(admin1);

		when(dao.getAllAdmins()).thenReturn(admins);
		assertEquals(3, controller.getAllAdmins().getBody().getData().size());
	}

	@Test
	public void updateAdminTest() {

		Admin admin = new Admin();
		when(dao.updateAdmin(1, admin)).thenReturn(admin);
		assertEquals(admin, controller.updateAdmin(admin, 1).getBody().getData());
	}

	@Test
	public void deleteAdminTest() {

		boolean b = true;
		String del="Admin deleted";
		when(dao.deleteAdmin(1)).thenReturn(b);
		assertEquals(del, controller.deleteAdmin(1).getBody().getData());

	}

}
