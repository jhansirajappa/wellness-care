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

import com.ty.wellness_care.dto.MedOrder;
import com.ty.wellness_care.service.MedOrderService;
import com.ty.wellness_care.util.ResponseStructure;

@RestController
public class MedOrderController {

	@Autowired
	MedOrderService medOrderService;

	@PostMapping("prescription/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder) {
		return medOrderService.saveMedOrder(medOrder);
	}

	@PutMapping("prescription/medorder/{medorderid}")
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@PathVariable int medorderid,
			@RequestBody MedOrder medOrder) {
		return medOrderService.updateMedOrder(medorderid, medOrder);
	}

	@GetMapping("prescription/medorder")
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getAllMedOrders() {
		return medOrderService.getAllMedOrders();
	}

	@GetMapping("prescription/medorder/{medorderid}")
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(@PathVariable int medorderid) {
		return medOrderService.getMedOrderById(medorderid);
	}

	@GetMapping("prescription/{prescriptionid}/medorder")
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getMedOrderByPrescription(
			@PathVariable int prescriptionId) {
		return medOrderService.getMedOrderByPrescription(prescriptionId);
	}

	@DeleteMapping("prescription/medorder")
	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(@RequestParam int id) {
		return medOrderService.deleteMedOrder(id);
	}

}
