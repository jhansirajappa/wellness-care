package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.wellness_care.dao.MedOrderDao;
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
		ResponseStructure<MedOrder> structure = new ResponseStructure<MedOrder>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("successful");
		structure.setData(medOrderDao.saveMedOrder(medOrder));
		ResponseEntity<ResponseStructure<MedOrder>> responseEntity = new ResponseEntity<ResponseStructure<MedOrder>>(
				structure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(int id, MedOrder medOrder) {
		MedOrder medOrder2 = medOrderDao.updateMedOrder(id, medOrder);
		if (medOrder2 != null) {
			ResponseStructure<MedOrder> responseStructure = new ResponseStructure<MedOrder>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(medOrder2);
			ResponseEntity<ResponseStructure<MedOrder>> responseEntity = new ResponseEntity<ResponseStructure<MedOrder>>(
					responseStructure, HttpStatus.OK);
			return responseEntity;
		} else {
			throw new IDNotFoundException("MedOrder Id: " + id + " not found/exists");

		}

	}

	@Override
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getAllMedOrders() {
		List<MedOrder> list = medOrderDao.getAllMedOrders();
		ResponseStructure<List<MedOrder>> structure = new ResponseStructure<List<MedOrder>>();

		if (list != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("successful");
			structure.setData(list);
			ResponseEntity<ResponseStructure<List<MedOrder>>> reponseEntity = new ResponseEntity<ResponseStructure<List<MedOrder>>>(
					structure, HttpStatus.OK);

			return reponseEntity;
		} else {
			return null;
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(int id) {

		MedOrder medOrder = medOrderDao.getMedOrderById(id);
		if (medOrder != null) {
			ResponseStructure<MedOrder> structure = new ResponseStructure<MedOrder>();
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("successfull");
			structure.setData(medOrder);
			ResponseEntity<ResponseStructure<MedOrder>> responseEntity = new ResponseEntity<ResponseStructure<MedOrder>>(
					structure, HttpStatus.OK);

			return responseEntity;
		} else {
			throw new IDNotFoundException("MedOrder Id: " + id + " not found/exists");

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
