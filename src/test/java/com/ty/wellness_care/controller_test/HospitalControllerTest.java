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

import com.ty.wellness_care.controller.HospitalController;
import com.ty.wellness_care.dao.HospitalDao;
import com.ty.wellness_care.dto.Hospital;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HospitalControllerTest {

	@Autowired
	private HospitalController controller;

	@MockBean
	private HospitalDao dao;

	@Test
	public void saveHospitalTest() {

		Hospital hospital = new Hospital();
		when(dao.saveHospital(hospital)).thenReturn(hospital);
		assertEquals(hospital, controller.saveHospital(hospital).getBody().getData());
	}

	@Test
	public void getHospitalByIdTest() {

		Hospital hospital = new Hospital();
		when(dao.getHospitalById(1)).thenReturn(hospital);
		assertEquals(hospital, controller.getHospitalById(1).getBody().getData());

	}

	@Test
	public void getAllHospitalsTest() {
		List<Hospital> hospitals = new ArrayList<Hospital>();
		Hospital hospital1 = new Hospital();
		Hospital hospital2 = new Hospital();
		Hospital hospital3 = new Hospital();
		hospitals.add(hospital1);
		hospitals.add(hospital2);
		hospitals.add(hospital3);

		when(dao.getAllHospital()).thenReturn(hospitals);
		assertEquals(3, controller.getAllHospital().getBody().getData().size());
	}

	@Test
	public void updateHospitalTest() {

		Hospital hospital = new Hospital();
		when(dao.updateHospital(1, hospital)).thenReturn(hospital);
		assertEquals(hospital, controller.updateHospital(hospital, 1).getBody().getData());
	}

	@Test
	public void deleteHospitalTest() {

		boolean b = true;
		String del="Hospital deleted";
		when(dao.deleteHospital(1)).thenReturn(b);
		assertEquals(del, controller.deleteHospital(1).getBody().getData());

	}

}
