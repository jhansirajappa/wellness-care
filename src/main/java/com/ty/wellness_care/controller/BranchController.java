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
import com.ty.wellness_care.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;

	@PostMapping("hospital/branch")
	@ApiOperation("To Save branch")
	@ApiResponses({@ApiResponse(code=200,message="Retrived branch"),
		@ApiResponse(code=404,message = "ID not found"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);

	}

	@PutMapping("hospital/branch/{id}")
	@ApiOperation("To update branch")
	@ApiResponses({@ApiResponse(code=200,message="branch updated"),
		@ApiResponse(code=404,message = "ID not found"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch, @PathVariable int id) {
		return branchService.updateBranch(id, branch);
	}

	@GetMapping("hospital/branch")
	@ApiOperation("To get all branches")
	@ApiResponses({@ApiResponse(code=200,message="Retrived branches"),
		@ApiResponse(code=404,message = "ID not found"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranch() {
		return branchService.getAllBranch();
	}

	@GetMapping("hospital/branch/{id}")
	@ApiOperation("To get branch by id")
	@ApiResponses({@ApiResponse(code=200,message="Retrived branch"),
		@ApiResponse(code=404,message = "ID not found"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@PathVariable int id) {
		return branchService.getBranchById(id);
	}

	@GetMapping("hospital/{hospitalid}/branch")
	@ApiOperation("To branch by hospital")
	@ApiResponses({@ApiResponse(code=200,message="Retrived branch"),
		@ApiResponse(code=404,message = "ID not found"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByHospital(@PathVariable int hospitalid) {
		return branchService.getBranchByHospital(hospitalid);
	}

	@DeleteMapping("hospital/branch")
	@ApiOperation("to delete the branch")
	@ApiResponses({@ApiResponse(code=200,message="branch deleted"),
		@ApiResponse(code=404,message = "ID not found"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<String>> deleteBranch(@RequestParam int id) {
		return branchService.deleteBranch(id);
	}

}
