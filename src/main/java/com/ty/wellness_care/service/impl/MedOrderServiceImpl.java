package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dao.MedOrderDao;
import com.ty.wellness_care.dto.MedOrder;
import com.ty.wellness_care.service.MedOrderService;
import com.ty.wellness_care.util.ResponseStructure;

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
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(int medOrderid, MedOrder medOrder) {
		MedOrder medOrder1 = medOrderDao.getMedOrderById(medOrderid);
		if (medOrder1 != null) {
			ResponseStructure<MedOrder> structure = new ResponseStructure<MedOrder>();
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("successful");
			structure.setData(medOrderDao.updateMedOrder(medOrderid, medOrder));
			ResponseEntity<ResponseStructure<MedOrder>> responseEntity = new ResponseEntity<ResponseStructure<MedOrder>>(
					structure, HttpStatus.OK);

			return responseEntity;

		} else {
			return null;
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
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getMedOrderByPrescription(int prescriptionId) {
		List<MedOrder> medOrder = medOrderDao.getMedOrderByPrescription(prescriptionId);
		if (medOrder != null) {
			ResponseStructure<List<MedOrder>> structure = new ResponseStructure<List<MedOrder>>();
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("successfull");
			structure.setData(medOrder);
			ResponseEntity<ResponseStructure<List<MedOrder>>> responseEntity = new ResponseEntity<ResponseStructure<List<MedOrder>>>(
					structure, HttpStatus.OK);

			return responseEntity;
		} else {
			return null;
		}

	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(int medOrderid) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity;

		if (medOrderDao.deleteMedOrder(medOrderid)) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("successful");
			structure.setData("Medorder deleted");
			responseEntity = new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
			return responseEntity;
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
			return null;
		}
	}

}
