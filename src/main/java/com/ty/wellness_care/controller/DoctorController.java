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
import org.springframework.web.bind.annotation.RestController;

import com.ty.wellness_care.dto.Doctor;
import com.ty.wellness_care.service.DoctorService;
import com.ty.wellness_care.util.ResponseStructure;

@RestController
public class DoctorController {

	@Autowired
	DoctorService doctorService;
	
@PostMapping("hospital/doctor")
	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(@RequestBody Doctor doctor) {
	return doctorService.saveDoctor(doctor);

}

@PutMapping("hospital/doctor/{doctorid}")
public ResponseEntity<ResponseStructure<Doctor>> updateDoctor(@PathVariable int id,@RequestBody
		Doctor doctor) {
		return doctorService.updateDoctor(id, doctor);
	}

@GetMapping("hospital/doctor")
public ResponseEntity<ResponseStructure<List<Doctor>>> getAllDoctor() {
		return doctorService.getAllDoctor();
	}

@GetMapping("hospital/doctor/{doctorid}")
	public ResponseEntity<ResponseStructure<Doctor>> getDoctorById(@PathVariable int id) {
		return doctorService.getDoctorById(id);
	}

@GetMapping("hospital/{hospitalid}/doctor")
public ResponseEntity<ResponseStructure<List<Doctor>>> getDoctorByHospital(int hospitalid) {
		return doctorService.getDoctorByHospital(hospitalid);
	}

@DeleteMapping("hospital/doctor")
	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(int id) {
		return doctorService.deleteMedOrder(id);
	}

	
}
