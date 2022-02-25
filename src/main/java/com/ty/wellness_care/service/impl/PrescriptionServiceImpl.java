package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.wellness_care.dao.PrescriptionDao;
import com.ty.wellness_care.dto.Prescription;
import com.ty.wellness_care.exception.IDNotFoundException;
import com.ty.wellness_care.service.PrescriptionService;
import com.ty.wellness_care.util.ResponseStructure;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

	@Autowired
	PrescriptionDao dao;

	@Override
	public ResponseEntity<ResponseStructure<Prescription>> savePrescription(Prescription prescription) {
		ResponseStructure<Prescription> responseStructure = new ResponseStructure<Prescription>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(dao.savePrescription(prescription));
		ResponseEntity<ResponseStructure<Prescription>> responseEntity = new ResponseEntity<ResponseStructure<Prescription>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Prescription>> updatePrescription(int id, Prescription prescription) {
		ResponseStructure<Prescription> responseStructure = new ResponseStructure<Prescription>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(dao.updatePrescription(id, prescription));
		ResponseEntity<ResponseStructure<Prescription>> responseEntity = new ResponseEntity<ResponseStructure<Prescription>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Prescription>>> getAllPrescription() {
		ResponseStructure<List<Prescription>> responseStructure = new ResponseStructure<List<Prescription>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(dao.getAllPrescription());
		ResponseEntity<ResponseStructure<List<Prescription>>> responseEntity = new ResponseEntity<ResponseStructure<List<Prescription>>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Prescription>>> getPrescriptionByDoctor(int doctorid) {
		ResponseStructure<List<Prescription>> responseStructure = new ResponseStructure<List<Prescription>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(dao.getPrescriptionByDoctor(doctorid));
		ResponseEntity<ResponseStructure<List<Prescription>>> responseEntity = new ResponseEntity<ResponseStructure<List<Prescription>>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;

	}

	@Override
	public ResponseEntity<ResponseStructure<Prescription>> getPrescriptionById(int prescriptionId) {
		ResponseStructure<Prescription> responseStructure = new ResponseStructure<Prescription>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(dao.getPrescriptionById(prescriptionId));
		ResponseEntity<ResponseStructure<Prescription>> responseEntity = new ResponseEntity<ResponseStructure<Prescription>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deletePrescription(int id) {
		if (dao.deletePrescription(id)) {
			ResponseStructure<String> responseStructure = new ResponseStructure<String>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData("Prescription Deleted");
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
					responseStructure, HttpStatus.OK);
			return responseEntity;

		} else {
			throw new IDNotFoundException("Prescription Id: " + id + " not found/exists");

		}

	}

}
