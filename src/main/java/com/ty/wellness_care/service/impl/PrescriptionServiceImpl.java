package com.ty.wellness_care.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.wellness_care.dao.PrescriptionDao;
import com.ty.wellness_care.dto.Prescription;
import com.ty.wellness_care.email.api.EmailSenderService;
import com.ty.wellness_care.exception.IDNotFoundException;
import com.ty.wellness_care.service.PrescriptionService;
import com.ty.wellness_care.util.MailCustomization;
import com.ty.wellness_care.util.ResponseStructure;
import com.ty.wellness_care.util.BillOperations;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

	@Autowired
	PrescriptionDao dao;
	@Autowired
	EmailSenderService emailSenderService;
	@Autowired
	MailCustomization mailCustomization;
	@Autowired
	BillOperations calculation;

	@Override
	public ResponseEntity<ResponseStructure<Prescription>> savePrescription(Prescription prescription) {
		prescription.setDateTime(LocalDateTime.now());
		prescription.setTotalCost(calculation.getTotal(prescription.getMedications()));
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
		Prescription prescription2 = dao.updatePrescription(id, prescription);
		if (prescription2 != null) {
			ResponseStructure<Prescription> responseStructure = new ResponseStructure<Prescription>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(prescription2);
			ResponseEntity<ResponseStructure<Prescription>> responseEntity = new ResponseEntity<ResponseStructure<Prescription>>(
					responseStructure, HttpStatus.OK);
			return responseEntity;
		} else {
			throw new IDNotFoundException("Prescription Id: " + id + " not found/exists");

		}
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
		Prescription prescription = dao.getPrescriptionById(prescriptionId);
		if (prescription != null) {
			ResponseStructure<Prescription> responseStructure = new ResponseStructure<Prescription>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(prescription);
			ResponseEntity<ResponseStructure<Prescription>> responseEntity = new ResponseEntity<ResponseStructure<Prescription>>(
					responseStructure, HttpStatus.OK);
			return responseEntity;
		} else {
			throw new IDNotFoundException("Prescription Id: " + prescriptionId + " not found/exists");

		}
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

	@Override
	public ResponseEntity<ResponseStructure<Prescription>> getMailOfPrescription(int prescriptionid) {
		Prescription prescription = dao.getPrescriptionById(prescriptionid);
		if (prescription != null) {
			ResponseStructure<Prescription> responseStructure = new ResponseStructure<Prescription>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Mail Sent");
			responseStructure.setData(prescription);
			mailCustomization.sentMail(prescription);
			ResponseEntity<ResponseStructure<Prescription>> responseEntity = new ResponseEntity<ResponseStructure<Prescription>>(
					responseStructure, HttpStatus.OK);
			return responseEntity;
		} else {

			throw new IDNotFoundException("Prescription Id: " + prescriptionid + " not found/exists");
		}
	}

}
