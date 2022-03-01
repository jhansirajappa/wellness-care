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

import com.ty.wellness_care.controller.LabController;
import com.ty.wellness_care.dao.LabDao;
import com.ty.wellness_care.dto.Lab;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LabControllerTest {

	@Autowired
	private LabController controller;

	@MockBean
	private LabDao dao;

	@Test
	public void saveLabTest() {

		Lab lab = new Lab();
		when(dao.saveLab(lab)).thenReturn(lab);
		assertEquals(lab, controller.saveLab(lab).getBody().getData());
	}

	@Test
	public void getLabByIdTest() {

		Lab lab = new Lab();
		when(dao.getLabById(1)).thenReturn(lab);
		assertEquals(lab, controller.getLabById(1).getBody().getData());

	}

	@Test
	public void getAllLabsTest() {
		List<Lab> labs = new ArrayList<Lab>();
		Lab lab1 = new Lab();
		Lab lab2 = new Lab();
		Lab lab3 = new Lab();

		labs.add(lab1);
		labs.add(lab2);
		labs.add(lab3);

		when(dao.getAllLabs()).thenReturn(labs);
		assertEquals(3, controller.getAllLabs().getBody().getData().size());
	}

	@Test
	public void updateLabTest() {

		Lab lab = new Lab();
		when(dao.updateLab(1, lab)).thenReturn(lab);
		assertEquals(lab, controller.updateLab(1, lab).getBody().getData());
	}

	@Test
	public void deleteLabTest() {

		boolean b = true;
		String del = "Lab Deleted";
		when(dao.deleteLab(1)).thenReturn(b);
		assertEquals(del, controller.deleteLab(1).getBody().getData());

	}

}
