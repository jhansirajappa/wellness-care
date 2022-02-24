package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.wellness_care.dao.MedOrderDao;
import com.ty.wellness_care.dto.Appointment;
import com.ty.wellness_care.dto.MedOrder;
import com.ty.wellness_care.exception.IDNotFoundException;
import com.ty.wellness_care.service.MedOrderService;
import com.ty.wellness_care.util.ResponseStructure;

@Service
public class MedOrderServiceImpl implements MedOrderService {

	@Autowired
	MedOrderDao medOrderDao;
	
	@Override
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder) {
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(medOrderDao.saveMedOrder(medOrder));
		ResponseEntity<ResponseStructure<MedOrder>> responseEntity = new ResponseEntity<ResponseStructure<MedOrder>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;

	}

	@Override
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(int id, MedOrder medOrder) {
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(medOrderDao.updateMedOrder(id, medOrder));
		ResponseEntity<ResponseStructure<MedOrder>> responseEntity = new ResponseEntity<ResponseStructure<MedOrder>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getAllMedOrders() {
		List<MedOrder> medOrders = medOrderDao.getAllMedOrders();
		ResponseStructure<List<MedOrder>> responseStructure = new ResponseStructure<List<MedOrder>>();
		if (medOrders != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(medOrders);
			ResponseEntity<ResponseStructure<List<MedOrder>>> responseEntity = new ResponseEntity<ResponseStructure<List<MedOrder>>>(
					responseStructure, HttpStatus.OK);

			return responseEntity;

		} else {
			throw new IDNotFoundException(" No Appointment found to display");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(int id) {
		ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(medOrderDao.getMedOrderById(id));
		ResponseEntity<ResponseStructure<MedOrder>> responseEntity = new ResponseEntity<ResponseStructure<MedOrder>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;	}

	@Override
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getMedOrderByPrescription(int prescriptionId) {
	
		List<MedOrder> medOrders = medOrderDao.getMedOrderByPrescription(prescriptionId);
		ResponseStructure<List<MedOrder>> responseStructure = new ResponseStructure<List<MedOrder>>();
		if (medOrders != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(medOrders);
			ResponseEntity<ResponseStructure<List<MedOrder>>> responseEntity = new ResponseEntity<ResponseStructure<List<MedOrder>>>(
					responseStructure, HttpStatus.OK);

			return responseEntity;

		} else {
			throw new IDNotFoundException(" No Appointment found to display");
		}

		
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(int id) {
		if (medOrderDao.deleteMedOrder(id)) {
			ResponseStructure<String> responseStructure = new ResponseStructure<String>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData("MedOrder Deleted");
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
					responseStructure, HttpStatus.OK);
			return responseEntity;

		} else {
			throw new IDNotFoundException("MedOrder Id: " + id + " not found/exists");

		}

	}

}
