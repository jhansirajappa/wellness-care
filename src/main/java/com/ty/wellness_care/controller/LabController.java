package com.ty.wellness_care.controller;

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

import com.ty.wellness_care.dto.Lab;
import com.ty.wellness_care.service.LabService;
import com.ty.wellness_care.util.ResponseStructure;

import antlr.collections.List;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class LabController {

	@Autowired
	LabService service;
	
	@PostMapping("branch/lab")
	public ResponseEntity<ResponseStructure<Lab>> saveLab(@RequestBody Lab lab) {
		return null;
		
	}
	@GetMapping("branch/{branchid}/lab")
	public ResponseEntity<ResponseStructure<Lab>> getLabByBranch(@PathVariable int branchid) {
		return null;
	}
	@GetMapping("prescription/{prescriptionid}/lab")
	public ResponseEntity<ResponseStructure<Lab>> getLabByPrescription(@PathVariable int prescriptionid) {
		return null;
	}
	@GetMapping("branch/lab")
	public ResponseEntity<ResponseStructure<Lab>> getAllLabs() {
		return null;
	}
	@PutMapping("branch/{branchid}/lab/{labid}")
	public ResponseEntity<ResponseStructure<Lab>> updateLab(@RequestBody Lab lab ,@PathVariable int branchid,@PathVariable int labid) {
		return null;
	}
	@DeleteMapping("branch/lab")
	public ResponseEntity<ResponseStructure<String>> deleteLab(@RequestParam int id) {
		return null;
	}
}
