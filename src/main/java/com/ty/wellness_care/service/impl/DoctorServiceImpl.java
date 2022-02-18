package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.Doctor;
import com.ty.wellness_care.service.DoctorService;
import com.ty.wellness_care.util.ResponseStructure;

public class DoctorServiceImpl implements DoctorService{

	@Override
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Doctor>> updateDoctor(int id, Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Doctor>>> getAllDoctor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Doctor>>> getDoctorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Doctor>>> getDoctorByHospital(int hospitalid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
