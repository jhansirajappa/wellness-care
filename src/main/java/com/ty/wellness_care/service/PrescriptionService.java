package com.ty.wellness_care.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.Prescription;
import com.ty.wellness_care.util.ResponseStructure;

public interface PrescriptionService {
	public ResponseEntity<ResponseStructure<Prescription>> savePrescription(Prescription prescription);
	public ResponseEntity<ResponseStructure<Prescription>> updatePrescription(int id,Prescription prescription);
	public ResponseEntity<ResponseStructure<List<Prescription>>> getAllPrescription();
	public ResponseEntity<ResponseStructure<List<Prescription>>> getPrescriptionByDoctor( int doctorid);
	public ResponseEntity<ResponseStructure<Prescription>> getPrescriptionById(int prescriptionId);
	public ResponseEntity<ResponseStructure<String>> deletePrescription(int id);
	public ResponseEntity<ResponseStructure<Prescription>> getMailOfPrescription(int prescriptionid);

}
