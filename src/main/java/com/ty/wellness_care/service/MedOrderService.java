package com.ty.wellness_care.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.MedOrder;
import com.ty.wellness_care.util.ResponseStructure;

public interface MedOrderService {

	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder);

	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(int id, MedOrder medOrder);

	public ResponseEntity<ResponseStructure<List<MedOrder>>> getAllMedOrders();

	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(int id);

	public ResponseEntity<ResponseStructure<List<MedOrder>>> getMedOrderByPrescription(int prescriptionId);

	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(int id);

}
