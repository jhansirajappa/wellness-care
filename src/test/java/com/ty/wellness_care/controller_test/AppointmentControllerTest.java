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

import com.ty.wellness_care.controller.AppointmentController;
import com.ty.wellness_care.dao.AppointmentDao;
import com.ty.wellness_care.dto.Appointment;

@RunWith(SpringRunner.class)
@SpringBootApplication
public class AppointmentControllerTest {

	@Autowired
	private AppointmentController controller;

	@MockBean
	private AppointmentDao dao;

	@Test
	public void saveAppointmentTest() {

		Appointment appointment = new Appointment();
		when(dao.saveAppointment(null)).thenReturn(appointment);
		assertEquals(appointment, controller.saveAppointment(appointment).getBody().getData());
	}

	@Test
	public void getAppointmentByIdTest() {

		Appointment appointment = new Appointment();
		when(dao.getAppointmentById(1)).thenReturn(appointment);
		assertEquals(appointment, controller.getAppointmentById(1).getBody().getData());

	}

	@Test
	public void getAllAppointmentTest() {
		List<Appointment> appointments = new ArrayList<Appointment>();
		Appointment appointment1 = new Appointment();
		Appointment appointment2 = new Appointment();
		Appointment appointment3 = new Appointment();

		appointments.add(appointment3);
		appointments.add(appointment2);
		appointments.add(appointment1);

		when(dao.getAllAppointment()).thenReturn(appointments);
		assertEquals(3, controller.getAllAppointment().getBody().getData().size());
	}

	@Test
	public void updateAppointmentTest() {

		Appointment appointment3 = new Appointment();
		when(dao.updateAppointment(1, appointment3)).thenReturn(appointment3);
		assertEquals(appointment3, controller.updateAppointment(1, appointment3).getBody().getData());
	}

	@Test
	public void deleteAppointmentTest() {

		boolean b = true;
		String del = "Appointment deleted";
		when(dao.deleteAppointment(1)).thenReturn(b);
		assertEquals(del, controller.deleteAppointment(1).getBody().getData());

	}

}
