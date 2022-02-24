package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.wellness_care.dao.AppointmentDao;
import com.ty.wellness_care.dto.Appointment;
import com.ty.wellness_care.exception.IDNotFoundException;
import com.ty.wellness_care.service.AppointmentService;
import com.ty.wellness_care.util.ResponseStructure;


@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentDao appointmentDao;
	
	@Override
	public ResponseEntity<ResponseStructure<Appointment>> saveAppointment(Appointment appointment) {
		ResponseStructure<Appointment> responseStructure = new ResponseStructure<Appointment>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(appointmentDao.saveAppointment(appointment));
		ResponseEntity<ResponseStructure<Appointment>> responseEntity = new ResponseEntity<ResponseStructure<Appointment>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Appointment>> updateAppointment(int id, Appointment appointment) {
		Appointment appointment2 = appointmentDao.updateAppointment(id, appointment);
		if (appointment2 != null) {
			ResponseStructure<Appointment> responseStructure = new ResponseStructure<Appointment>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(appointment2);
			ResponseEntity<ResponseStructure<Appointment>> responseEntity = new ResponseEntity<ResponseStructure<Appointment>>(
					responseStructure, HttpStatus.OK);
			return responseEntity;

		} else {
			throw new IDNotFoundException("Appointment Id: " + id + " not found/exists");

		}


	}

	@Override
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAllAppointment() {
		List<Appointment> appointments = appointmentDao.getAllAppointment();
		ResponseStructure<List<Appointment>> responseStructure = new ResponseStructure<List<Appointment>>();
		if (appointments != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(appointments);
			ResponseEntity<ResponseStructure<List<Appointment>>> responseEntity = new ResponseEntity<ResponseStructure<List<Appointment>>>(
					responseStructure, HttpStatus.OK);

			return responseEntity;

		} else {
			throw new IDNotFoundException(" No Appointment found to display");
		}

	}


	@Override
	public ResponseEntity<ResponseStructure<String>> deleteAppointment(int id) {
		if (appointmentDao.deleteAppointment(id)) {
			ResponseStructure<String> responseStructure = new ResponseStructure<String>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData("Appointment Deleted");
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
					responseStructure, HttpStatus.OK);
			return responseEntity;

		} else {
			throw new IDNotFoundException("Appointment Id: " + id + " not found/exists");

		}

	}

	@Override
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAppointmentByBranch(int id) {
		List<Appointment> appointments = appointmentDao.getAppointmentByBranch(id);
		ResponseStructure<List<Appointment>> responseStructure = new ResponseStructure<List<Appointment>>();
		if (appointments != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(appointments);
			ResponseEntity<ResponseStructure<List<Appointment>>> responseEntity = new ResponseEntity<ResponseStructure<List<Appointment>>>(
					responseStructure, HttpStatus.OK);

			return responseEntity;

		} else {
			throw new IDNotFoundException(" No Appointment found to display");
		}

	}

	@Override
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAppointmentByUser(int id) {
		List<Appointment> appointments = appointmentDao.getAppointmentByUser(id);
		ResponseStructure<List<Appointment>> responseStructure = new ResponseStructure<List<Appointment>>();
		if (appointments != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(appointments);
			ResponseEntity<ResponseStructure<List<Appointment>>> responseEntity = new ResponseEntity<ResponseStructure<List<Appointment>>>(
					responseStructure, HttpStatus.OK);

			return responseEntity;

		} else {
			throw new IDNotFoundException(" No Appointment found to display");
		}

	}

	@Override
	public ResponseEntity<ResponseStructure<List<Appointment>>> getAppointmentByDoctor(int id) {
		List<Appointment> appointments = appointmentDao.getAppointmentByDoctor(id);
		ResponseStructure<List<Appointment>> responseStructure = new ResponseStructure<List<Appointment>>();
		if (appointments != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(appointments);
			ResponseEntity<ResponseStructure<List<Appointment>>> responseEntity = new ResponseEntity<ResponseStructure<List<Appointment>>>(
					responseStructure, HttpStatus.OK);

			return responseEntity;

		} else {
			throw new IDNotFoundException(" No Appointment found to display");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Appointment>> getAppointmentById(int appointmentId) {
		Appointment appointments = appointmentDao.getAppointmentById(appointmentId);
		ResponseStructure<Appointment> responseStructure = new ResponseStructure<Appointment>();
		if (appointments != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(appointments);
			ResponseEntity<ResponseStructure<Appointment>> responseEntity = new ResponseEntity<ResponseStructure<Appointment>>(
					responseStructure, HttpStatus.OK);

			return responseEntity;

		} else {
			throw new IDNotFoundException(" No Appointment found to display");
		}
	}

}
