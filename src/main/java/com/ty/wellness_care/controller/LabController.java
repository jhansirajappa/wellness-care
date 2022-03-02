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

import com.ty.wellness_care.dto.Lab;
import com.ty.wellness_care.service.LabService;
import com.ty.wellness_care.util.ResponseStructure;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class LabController {

	@Autowired
	LabService labService;

	@PostMapping("branch/lab")
	@ApiResponses({@ApiResponse(code=200,message="Lab Saved"),
		@ApiResponse(code=404,message = "Lab not saved"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Lab>> saveLab(@RequestBody Lab lab) {
		return labService.saveLab(lab);

	}

	@GetMapping("branch/{branchid}/lab")
	@ApiResponses({@ApiResponse(code=200,message="Lab retrieved"),
		@ApiResponse(code=404,message = "Lab not retrieved"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Lab>> getLabByBranch(@PathVariable int branchid) {
		return labService.getLabByBranch(branchid);
	}

	@GetMapping("prescription/{prescriptionid}/lab")
	@ApiResponses({@ApiResponse(code=200,message="Lab retrieved"),
		@ApiResponse(code=404,message = "Lab not retrieved"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Lab>> getLabByPrescription(@PathVariable int prescriptionid) {
		return labService.getLabByPrescription(prescriptionid);
	}

	@GetMapping("branch/lab")
	@ApiResponses({@ApiResponse(code=200,message="Labs retrieved"),
		@ApiResponse(code=404,message = "Labs not retrieved"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Lab>>> getAllLabs() {
		return labService.getAllLab();
	}

	

	@DeleteMapping("branch/lab/{labid}")
	@ApiResponses({@ApiResponse(code=200,message="Lab deleted"),
		@ApiResponse(code=404,message = "Lab not deleted"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Lab>> getLabById(@PathVariable int labid) {
		return labService.getLabById(labid);
	}
	
	@DeleteMapping("branch/lab")
	@ApiResponses({@ApiResponse(code=200,message="Lab deleted"),
		@ApiResponse(code=404,message = "Lab not deleted"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<String>> deleteLab(@RequestParam int id) {
		return labService.deleteLab(id);
	}

	@PutMapping("branch/{branchid}/lab/{labid}")
	@ApiResponses({@ApiResponse(code=200,message="Lab updated"),
		@ApiResponse(code=404,message = "Lab not updated"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Lab>> updateLab(@PathVariable int labid, @RequestBody Lab lab) {
		return labService.updateLab(lab, labid);
	}
}
