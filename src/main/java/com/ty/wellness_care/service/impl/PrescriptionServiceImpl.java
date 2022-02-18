package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.Prescription;
import com.ty.wellness_care.service.PrescriptionService;
import com.ty.wellness_care.util.ResponseStructure;

public class PrescriptionServiceImpl implements PrescriptionService {

	@Override
	public ResponseEntity<ResponseStructure<Prescription>> savePrescription(Prescription prescription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Prescription>> updatePrescription(int id, Prescription prescription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Prescription>>> getAllPrescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Prescription>>> getPrescriptionByDoctor(int doctorid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Prescription>>> getPrescriptionById(int prescriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deletePrescription(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
