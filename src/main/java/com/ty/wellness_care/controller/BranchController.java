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

import com.ty.wellness_care.dto.Branch;
import com.ty.wellness_care.service.BranchService;
import com.ty.wellness_care.service.HospitalService;
import com.ty.wellness_care.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;
	
	@PostMapping("hospital/branch")
	@ApiOperation("To Save Branch")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
	 return branchService.saveBranch(branch);
	}

	@PutMapping("hospital/branch/{branchid}")
	@ApiOperation("To Update Branch By Id")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@PathVariable int branchid,@RequestBody Branch branch) {
		return branchService.updateBranch(branchid, branch);
	}

	@GetMapping("hospital/branch")
	@ApiOperation("To Get All Branches")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranch() {
		return branchService.getAllBranch();
	}

	@GetMapping("hospital/branch/{branchid}")
	@ApiOperation("To Get Branch By Id")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@PathVariable int branchid) {
		return branchService.getBranchById(branchid);
	}

	@GetMapping("hospital/{hospitalid}/branch")
	@ApiOperation("To Get Branch By Hospital Id")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByHospital(@PathVariable int branchid) {
		return branchService.getBranchByHospital(branchid);
	}

	@DeleteMapping("hospital/branch")
	@ApiOperation("To Delete Branch By Id")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<String>> deleteBranch(@RequestParam int id) {
		return branchService.deleteBranch(id);
	}

}
