package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.Appointment;
import com.ty.wellness_care.service.AppointmentService;
import com.ty.wellness_care.util.ResponseStructure;

public class AppointmentServiceImpl implements AppointmentService {

	@Override
	public ResponseEntity<ResponseStructure<Appointment>> saveAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Appointment>> updateAppointment(int id, Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAllAppointment() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResponseEntity<ResponseStructure<String>> deleteAppointment(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAppointmentByBranch(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAppointmentByUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAppointmentByDoctor(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAppointmentById(int appointmentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
