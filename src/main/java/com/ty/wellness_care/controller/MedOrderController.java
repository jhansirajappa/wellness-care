package com.ty.wellness_care.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ty.wellness_care.dto.MedOrder;
import com.ty.wellness_care.util.ResponseStructure;

public class MedOrderController {


	@PostMapping("prescription/medorder")
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@PutMapping("prescription/medorder/{medorderid}")
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@PathVariable int medorderid,@RequestBody MedOrder medOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("prescription/medorder")
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getAllMedOrders() {
		// TODO Auto-generated method stub
		return null;
	}


	@GetMapping("prescription/medorder/{medorderid}")
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getMedOrderById(@PathVariable int medorderid) {
		// TODO Auto-generated method stub
		return null;
	}


	@GetMapping("prescription/{prescriptionid}/medorder")
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getMedOrderByPrescription(@PathVariable int prescriptionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("prescription/medorder")
	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(@RequestParam int id) {
		// TODO Auto-generated method stub
		return null;
	}


}
