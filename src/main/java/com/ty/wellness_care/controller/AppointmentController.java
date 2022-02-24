package com.ty.wellness_care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.wellness_care.dto.Appointment;
import com.ty.wellness_care.service.impl.AppointmentServiceImpl;
import com.ty.wellness_care.util.ResponseStructure;

@RestController
public class AppointmentController {

	@Autowired
	AppointmentServiceImpl appointmentServiceImpl;

	@PostMapping("user/appointment")
	public ResponseEntity<ResponseStructure<Appointment>> saveAppointment(@RequestBody Appointment appointment) {
		return appointmentServiceImpl.saveAppointment(appointment);
	}

	@PutMapping("user/appointment/{appointmentId}")
	public ResponseEntity<ResponseStructure<Appointment>> updateAppointment(@PathVariable int appointmentId,
			@RequestBody Appointment appointment) {
		return appointmentServiceImpl.updateAppointment(appointmentId, appointment);
	}

	@GetMapping("user/appointment")
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAllAppointment() {
		return appointmentServiceImpl.getAllAppointment();
	}

	@GetMapping("branch/{branchid}/appointment")
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAppointmentByBranch(@PathVariable int branchid,
			@PathVariable int appointmentid) {
		return appointmentServiceImpl.getAppointmentByBranch(appointmentid);
	}

	@GetMapping("user/{userid}/appointment")
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAppointmentByUser(@PathVariable int userid,
			@PathVariable int appointmentid) {
		return appointmentServiceImpl.getAppointmentByUser(appointmentid);
	}

	@GetMapping("doctor/{doctorid}/appointment")
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAppointmentByDoctor(@PathVariable int doctorid,
			@PathVariable int appointmentid) {
		return appointmentServiceImpl.getAppointmentByDoctor(appointmentid);
	}

	@GetMapping("appointment/{appointmentId}")
	public ResponseEntity<ResponseStructure<Appointment>> getAppointmentById(@PathVariable int appointmentId) {
		return appointmentServiceImpl.getAppointmentById(appointmentId);
	}

	@DeleteMapping("user/appointment")
	public ResponseEntity<ResponseStructure<String>> deleteAppointment(@RequestParam int id) {
		return appointmentServiceImpl.deleteAppointment(id);
	}
}
