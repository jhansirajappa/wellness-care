package com.ty.wellness_care.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.wellness_care.dto.Hospital;
import com.ty.wellness_care.util.ResponseStructure;

@RestController
public class HospitalController {

	@PostMapping("admin/hospital")
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
		// TODO Auto-generated method stub
		return null;
	}

	@PutMapping("admin/hospital/{hospitalid}")
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(@PathVariable int hospitalid,@RequestBody Hospital hospital) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("admin/hospital")
	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital() {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("admin/hospital/{hospitalid}")
	public ResponseEntity<ResponseStructure<List<Hospital>>> getHospitalById(@PathVariable int hospitalid) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("admin/{adminid}/hospital")
	public ResponseEntity<ResponseStructure<List<Hospital>>> getHospitalByAdmin(@PathVariable int hospitalid) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("admin/hospital")
	public String deleteHospital(@RequestParam int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
