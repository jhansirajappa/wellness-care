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

import com.ty.wellness_care.dto.Prescription;
import com.ty.wellness_care.service.PrescriptionService;
import com.ty.wellness_care.util.ResponseStructure;

@RestController
public class PrescriptionController {

	@Autowired
	PrescriptionService prescriptionService;

	@PostMapping("doctor/prescription")
	public ResponseEntity<ResponseStructure<Prescription>> savePrescription(@RequestBody Prescription prescription) {
		return prescriptionService.savePrescription(prescription);
	}

	@PutMapping("doctor/prescription/{prescriptionid}")
	public ResponseEntity<ResponseStructure<Prescription>> updatePrescription(@PathVariable int prescriptionid,
			@RequestBody Prescription prescription) {
		return prescriptionService.updatePrescription(prescriptionid, prescription);
	}

	@GetMapping("doctor/prescription")
	public ResponseEntity<ResponseStructure<List<Prescription>>> getAllPrescription() {
		return prescriptionService.getAllPrescription();
	}

	@GetMapping("doctor/{doctorid}/prescription")
	public ResponseEntity<ResponseStructure<List<Prescription>>> getPrescriptionByDoctor(@PathVariable int doctorid) {
		return prescriptionService.getPrescriptionByDoctor(doctorid);
	}

	@GetMapping("doctor/prescription/{prescriptionid}")
	public ResponseEntity<ResponseStructure<Prescription>> getPrescriptionById(@PathVariable int prescriptionid) {
		return prescriptionService.getPrescriptionById(prescriptionid);
	}

	@DeleteMapping("doctor/prescription")
	public ResponseEntity<ResponseStructure<String>> deletePrescription(@RequestParam int id) {
		return prescriptionService.deletePrescription(id);
	}

}
