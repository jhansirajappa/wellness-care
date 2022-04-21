package com.ty.wellness_care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.wellness_care.dto.Appointment;
import com.ty.wellness_care.service.AppointmentService;
import com.ty.wellness_care.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;

	@PostMapping("user/appointment")
	@ApiOperation("To Save Appointment")
	@ApiResponses({@ApiResponse(code=200,message="Retrived Appointment"),
		@ApiResponse(code=404,message = "ID not found"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Appointment>> saveAppointment(@Validated @RequestBody Appointment appointment) {
		return appointmentService.saveAppointment(appointment);
	}

	@PutMapping("user/appointment/{appointmentId}")
	@ApiOperation("To update appointment")
	@ApiResponses({@ApiResponse(code=200,message="Retrived appointment"),
		@ApiResponse(code=404,message = "ID not found"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Appointment>> updateAppointment(@PathVariable int appointmentId,
			@RequestBody Appointment appointment) {
		return appointmentService.updateAppointment(appointmentId, appointment);
	}

	@GetMapping("user/appointment")
	@ApiOperation("To get all appointments")
	@ApiResponses({@ApiResponse(code=200,message="Retrived all appointments"),
		@ApiResponse(code=404,message = "ID not found"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAllAppointment() {
		return appointmentService.getAllAppointment();
	}

	@GetMapping("branch/{branchid}/appointment")
	@ApiOperation("To get appointment by Branch")
	@ApiResponses({@ApiResponse(code=200,message="Retrived appointment"),
		@ApiResponse(code=404,message = "ID not found"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAppointmentByBranch(@PathVariable int branchid) {
		return appointmentService.getAppointmentByBranch(branchid);
	}

	@GetMapping("user/{userid}/appointment")
	@ApiOperation("To get appointment by user")
	@ApiResponses({@ApiResponse(code=200,message="Retrived appointment"),
		@ApiResponse(code=404,message = "ID not found"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAppointmentByUser(@PathVariable int userid) {
		return appointmentService.getAppointmentByUser(userid);
	}

	@GetMapping("doctor/{doctorid}/appointment")
	@ApiOperation("To get appointment by doctor")
	@ApiResponses({@ApiResponse(code=200,message="Retrived appointment"),
		@ApiResponse(code=404,message = "ID not found"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAppointmentByDoctor(@PathVariable int doctorid) {
		return appointmentService.getAppointmentByDoctor(doctorid);
	}

	@GetMapping("appointment/{appointmentId}")
	@ApiOperation("To appointment by id")
	@ApiResponses({@ApiResponse(code=200,message="Retrived appointment"),
		@ApiResponse(code=404,message = "ID not found"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Appointment>> getAppointmentById(@PathVariable int appointmentId) {
		return appointmentService.getAppointmentById(appointmentId);
	}

	@DeleteMapping("user/appointment/{appointmentid}")
	@ApiOperation("To delete appointment")
	@ApiResponses({@ApiResponse(code=200,message="appointment deleted "),
		@ApiResponse(code=404,message = "ID not found"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<String>> deleteAppointment(@PathVariable int appointmentid) {
		return appointmentService.deleteAppointment(appointmentid);
	}
}
