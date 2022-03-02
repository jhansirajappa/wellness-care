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

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MedOrderController {

	@Autowired
	MedOrderService medOrderService;

	@PostMapping("prescription/medorder")
	@ApiResponses({ @ApiResponse(code = 200, message = "Medorder Saved"),
			@ApiResponse(code = 404, message = "Medorder not saved"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<ResponseStructure<MedOrder>> saveMedOrder(MedOrder medOrder) {
		return medOrderService.saveMedOrder(medOrder);
	}

	@PutMapping("prescription/medorder/{medorderid}")
	@ApiResponses({ @ApiResponse(code = 200, message = "Medorder updated"),
			@ApiResponse(code = 404, message = "Medorder not updated"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<ResponseStructure<MedOrder>> updateMedOrder(@PathVariable int medorderid,
			@RequestBody MedOrder medOrder) {
		return medOrderService.updateMedOrder(medorderid, medOrder);
	}

	@GetMapping("prescription/medorder")
	@ApiResponses({ @ApiResponse(code = 200, message = "Medorder Saved"),
			@ApiResponse(code = 404, message = "Medorder not updated"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getAllMedOrders() {
		return medOrderService.getAllMedOrders();
	}

	@GetMapping("prescription/medorder/{medorderid}")
	@ApiResponses({ @ApiResponse(code = 200, message = "Medorder retrieved"),
			@ApiResponse(code = 404, message = "Medorder not retrieved"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<ResponseStructure<MedOrder>> getMedOrderById(@PathVariable int medorderid) {
		return medOrderService.getMedOrderById(medorderid);
	}

	@GetMapping("prescription/{prescriptionid}/medorder")
	@ApiResponses({ @ApiResponse(code = 200, message = "Medorder retrieved"),
			@ApiResponse(code = 404, message = "Medorder not retrieved"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<ResponseStructure<List<MedOrder>>> getMedOrderByPrescription(
			@PathVariable int prescriptionid) {
		return medOrderService.getMedOrderByPrescription(prescriptionid);
	}

	@DeleteMapping("prescription/medorder")
	@ApiResponses({ @ApiResponse(code = 200, message = "Medorder deleted"),
			@ApiResponse(code = 404, message = "Medorder not deleted"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(@RequestParam int id) {
		return medOrderService.deleteMedOrder(id);
	}

}
