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

import com.ty.wellness_care.controller.DoctorController;
import com.ty.wellness_care.dao.DoctorDao;
import com.ty.wellness_care.dto.Doctor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorControllerTest {

	@Autowired
	private DoctorController controller;
	@MockBean
	private DoctorDao dao;

	@Test
	public void saveDoctorTest() {

		Doctor doctor = new Doctor();
		when(dao.saveDoctor(doctor)).thenReturn(doctor);
		assertEquals(doctor, controller.saveDoctor(doctor).getBody().getData());
	}

	@Test
	public void getDoctorByIdTest() {

		Doctor doctor = new Doctor();
		when(dao.getDoctorById(1)).thenReturn(doctor);
		assertEquals(doctor, controller.getDoctorById(1).getBody().getData());

	}

	@Test
	public void getAllDoctorTest() {
		List<Doctor> doctors = new ArrayList<Doctor>();
		Doctor doctor1 = new Doctor();
		Doctor doctor2 = new Doctor();
		Doctor doctor3 = new Doctor();

		doctors.add(doctor1);
		doctors.add(doctor2);
		doctors.add(doctor3);

		when(dao.getAllDoctor()).thenReturn(doctors);
		assertEquals(3, controller.getAllDoctor().getBody().getData().size());
	}

	@Test
	public void updateDoctorTest() {

		Doctor doctor = new Doctor();
		when(dao.updateDoctor(1, doctor)).thenReturn(doctor);
		assertEquals(doctor, controller.updateDoctor(1, doctor).getBody().getData());
	}

	@Test
	public void deleteDoctorTest() {

		boolean b = true;
		String del = "Doctor Deleted";
		when(dao.deleteDoctor(1)).thenReturn(b);
		assertEquals(del, controller.deleteDoctor(1).getBody().getData());

	}

}
