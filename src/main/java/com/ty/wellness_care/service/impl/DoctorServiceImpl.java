package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.wellness_care.dao.DoctorDao;
import com.ty.wellness_care.dto.Doctor;
import com.ty.wellness_care.exception.IDNotFoundException;
import com.ty.wellness_care.service.DoctorService;
import com.ty.wellness_care.util.ResponseStructure;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorDao doctorDao;

	@Override
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(Doctor doctor) {
		ResponseStructure<Doctor> responseStructure = new ResponseStructure<Doctor>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(doctorDao.saveDoctor(doctor));
		ResponseEntity<ResponseStructure<Doctor>> responseEntity = new ResponseEntity<ResponseStructure<Doctor>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;

	}

	@Override
	public ResponseEntity<ResponseStructure<Doctor>> updateDoctor(int id, Doctor doctor) {
		ResponseStructure<Doctor> responseStructure = new ResponseStructure<Doctor>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(doctorDao.updateDoctor(id, doctor));
		ResponseEntity<ResponseStructure<Doctor>> responseEntity = new ResponseEntity<ResponseStructure<Doctor>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Doctor>>> getAllDoctor() {
		ResponseStructure<List<Doctor>> responseStructure = new ResponseStructure<List<Doctor>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(doctorDao.getAllDoctor());
		ResponseEntity<ResponseStructure<List<Doctor>>> responseEntity = new ResponseEntity<ResponseStructure<List<Doctor>>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Doctor>> getDoctorById(int id) {

		ResponseStructure<Doctor> responseStructure = new ResponseStructure<Doctor>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(doctorDao.getDoctorById(id));
		ResponseEntity<ResponseStructure<Doctor>> responseEntity = new ResponseEntity<ResponseStructure<Doctor>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;

	}

	@Override
	public ResponseEntity<ResponseStructure<List<Doctor>>> getDoctorByHospital(int hospitalid) {
		ResponseStructure<List<Doctor>> responseStructure = new ResponseStructure<List<Doctor>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(doctorDao.getDoctorByHospital(hospitalid));
		ResponseEntity<ResponseStructure<List<Doctor>>> responseEntity = new ResponseEntity<ResponseStructure<List<Doctor>>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(int id) {
		if (doctorDao.deleteDoctor(id)) {
			ResponseStructure<String> responseStructure = new ResponseStructure<String>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData("Doctor Deleted");
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
					responseStructure, HttpStatus.OK);
			return responseEntity;

		} else {
			throw new IDNotFoundException("Doctor Id: " + id + " not found/exists");

		}

	}

}
