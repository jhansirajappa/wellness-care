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

import com.ty.wellness_care.controller.PrescriptionController;
import com.ty.wellness_care.dao.PrescriptionDao;
import com.ty.wellness_care.dto.Prescription;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrescriptionServiceTest {
	
	@Autowired
	private PrescriptionController controller;
	@MockBean
	private PrescriptionDao dao;

	@Test
	public void savePrescriptionTest() {

		Prescription prescription= new Prescription();
		when(dao.savePrescription(prescription)).thenReturn(prescription);
		assertEquals(prescription, controller.savePrescription(prescription).getBody().getData());
	}

	@Test
	public void getPrescriptionByIdTest() {

		Prescription prescription= new Prescription();
		when(dao.getPrescriptionById(1)).thenReturn(prescription);
		assertEquals(prescription, controller.getPrescriptionById(1).getBody().getData());

	}

	@Test
	public void getAllPrescriptionTest() {
		List<Prescription> prescriptions = new ArrayList<Prescription>();
		Prescription doctor1 = new Prescription();
		Prescription doctor2 = new Prescription();
		Prescription doctor3 = new Prescription();

		prescriptions.add(doctor1);
		prescriptions.add(doctor2);
		prescriptions.add(doctor3);

		when(dao.getAllPrescription()).thenReturn(prescriptions);
		assertEquals(3, controller.getAllPrescription().getBody().getData().size());
	}

	@Test
	public void updatePrescriptionTest() {

		Prescription prescription = new Prescription();
		when(dao.updatePrescription(1, prescription)).thenReturn(prescription);
		assertEquals(prescription, controller.updatePrescription(1, prescription).getBody().getData());
	}

	@Test
	public void deletePrescriptionTest() {

		boolean b = true;
		String del = "Prescription Deleted";
		when(dao.deletePrescription(1)).thenReturn(b);
		assertEquals(del, controller.deletePrescription(1).getBody().getData());

	}

}
