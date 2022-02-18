package com.ty.wellness_care.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ty.wellness_care.dto.Doctor;
import com.ty.wellness_care.util.ResponseStructure;

public class DoctorController {

@PostMapping("hospital/doctor")
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(@RequestBody Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

@PutMapping("hospital/doctor/{doctorid}")
public ResponseEntity<ResponseStructure<Doctor>> updateDoctor(@PathVariable int id,@RequestBody
		Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

@GetMapping("hospital/doctor")
public ResponseEntity<ResponseStructure<List<Doctor>>> getAllDoctor() {
		// TODO Auto-generated method stub
		return null;
	}

@GetMapping("hospital/doctor/{doctorid}")
	public ResponseEntity<ResponseStructure<List<Doctor>>> getDoctorById(@PathVariable int id) {
		// TODO Auto-generated method stub
		return null;
	}

@GetMapping("hospital/{hospitalid}/doctor")
public ResponseEntity<ResponseStructure<List<Doctor>>> getDoctorByHospital(int hospitalid) {
		// TODO Auto-generated method stub
		return null;
	}

@DeleteMapping("hospital/doctor")
	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
