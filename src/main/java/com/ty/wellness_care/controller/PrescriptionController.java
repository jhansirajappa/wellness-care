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

import com.ty.wellness_care.dto.Prescription;
import com.ty.wellness_care.util.ResponseStructure;

public class PrescriptionController {

@PostMapping("doctor/prescription")
	public ResponseEntity<ResponseStructure<Prescription>> savePrescription(@RequestBody Prescription prescription) {
		// TODO Auto-generated method stub
		return null;
	}

@PutMapping("doctor/prescription/{prescriptionid}")
public ResponseEntity<ResponseStructure<Prescription>> updatePrescription(@PathVariable int id,@RequestBody Prescription prescriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

@GetMapping("doctor/prescription")
public ResponseEntity<ResponseStructure<List<Prescription>>> getAllPrescription() {
		// TODO Auto-generated method stub
		return null;
	}

@GetMapping("doctor/{doctorid}/prescription")
public ResponseEntity<ResponseStructure<List<Prescription>>> getPrescriptionByDoctor(@PathVariable int doctorid) {
		// TODO Auto-generated method stub
		return null;
	}

@GetMapping("doctor/prescription/{prescriptionid}")
public ResponseEntity<ResponseStructure<List<Prescription>>> getPrescriptionById(@PathVariable int prescriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("doctor/prescription")
	public ResponseEntity<ResponseStructure<String>> deletePrescription(@RequestParam int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
