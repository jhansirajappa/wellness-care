package com.ty.wellness_care.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.ty.wellness_care.dto.Appointment;
import com.ty.wellness_care.util.ResponseStructure;

public interface AppointmentService {

	public ResponseEntity<ResponseStructure<Appointment>> saveAppointment(Appointment appointment);
	public ResponseEntity<ResponseStructure<Appointment>> updateAppointment(int id,Appointment appointment);
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAllAppointment();
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAppointmentByBranch( int id);
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAppointmentByUser( int id);
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAppointmentByDoctor( int id);
	public ResponseEntity<ResponseStructure<Appointment>> getAppointmentById( int appointmentId );	
	public ResponseEntity<ResponseStructure<String>> deleteAppointment(int id);
}
