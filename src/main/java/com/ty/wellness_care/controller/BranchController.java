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
import org.springframework.web.bind.annotation.RestController;

import com.ty.wellness_care.dto.Branch;
import com.ty.wellness_care.util.ResponseStructure;

@RestController
public class BranchController {

	@PostMapping("hospital/branch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		// TODO Auto-generated method stub
		return null;
	}

	@PutMapping("hospital/branch/{branchid}")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@PathVariable int branchid,@RequestBody Branch branch) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("hospital/branch")
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranch() {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("hospital/branch/{branchid}")
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchById(@PathVariable int branchid) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("hospital/{hospitalid}/branch")
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByHospital(@PathVariable int branchid) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("hospital/branch")
	public String deleteBranch(@RequestParam int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
