package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.wellness_care.dao.LabDao;
import com.ty.wellness_care.dto.Lab;
import com.ty.wellness_care.exception.IDNotFoundException;
import com.ty.wellness_care.service.LabService;
import com.ty.wellness_care.util.ResponseStructure;

@Service
public class LabServiceImpl implements LabService{

	@Autowired
	LabDao labDao;
	
	@Override
	public ResponseEntity<ResponseStructure<Lab>> saveLab(Lab lab) {
		ResponseStructure<Lab> responseStructure = new ResponseStructure<Lab>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(labDao.saveLab(lab));
		ResponseEntity<ResponseStructure<Lab>> responseEntity = new ResponseEntity<ResponseStructure<Lab>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Lab>> getLabById(int id) {
		Lab lab = labDao.getLabById(id);
		ResponseStructure<Lab> responseStructure = new ResponseStructure<Lab>();
		if (lab != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(lab);
			ResponseEntity<ResponseStructure<Lab>> responseEntity = new ResponseEntity<ResponseStructure<Lab>>(
					responseStructure, HttpStatus.OK);

			return responseEntity;

		} else {
			throw new IDNotFoundException(" No lab found to display");
		}
	}
	

	@Override
	public ResponseEntity<ResponseStructure<List<Lab>>> getAllLab() {
		List<Lab> lab = labDao.getAllLabs();
		ResponseStructure<List<Lab>> responseStructure = new ResponseStructure<List<Lab>>();
		if (lab != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(lab);
			ResponseEntity<ResponseStructure<List<Lab>>> responseEntity = new ResponseEntity<ResponseStructure<List<Lab>>>(
					responseStructure, HttpStatus.OK);

			return responseEntity;

		} else {
			throw new IDNotFoundException(" No Appointment found to display");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Lab>> updateLab(Lab lab, int id) {
		Lab lab1 = labDao.updateLab(id, lab);
		if (lab1 != null) {
			ResponseStructure<Lab> responseStructure = new ResponseStructure<Lab>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(lab1);
			ResponseEntity<ResponseStructure<Lab>> responseEntity = new ResponseEntity<ResponseStructure<Lab>>(
					responseStructure, HttpStatus.OK);
			return responseEntity;

		} else {
			throw new IDNotFoundException("Lab Id: " + id + " not found/exists");

		}
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteLab(int id) {
		if (labDao.deleteLab(id)) {
			ResponseStructure<String> responseStructure = new ResponseStructure<String>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData("Lab Deleted");
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
					responseStructure, HttpStatus.OK);
			return responseEntity;

		} else {
			throw new IDNotFoundException("Appointment Id: " + id + " not found/exists");

		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Lab>> getLabByPrescription(int id) {
		Lab lab = labDao.getLabByPrescription(id);
		ResponseStructure<Lab> responseStructure = new ResponseStructure<Lab>();
		if (lab != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(lab);
			ResponseEntity<ResponseStructure<Lab>> responseEntity = new ResponseEntity<ResponseStructure<Lab>>(
					responseStructure, HttpStatus.OK);

			return responseEntity;

		} else {
			throw new IDNotFoundException(" No Appointment found to display");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Lab>> getLabByBranch(int id) {
		Lab lab = labDao.getLabByBranch(id);
		ResponseStructure<Lab> responseStructure = new ResponseStructure<Lab>();
		if (lab != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(lab);
			ResponseEntity<ResponseStructure<Lab>> responseEntity = new ResponseEntity<ResponseStructure<Lab>>(
					responseStructure, HttpStatus.OK);

			return responseEntity;

		} else {
			throw new IDNotFoundException(" No Appointment found to display");
		}
	}


	

}
