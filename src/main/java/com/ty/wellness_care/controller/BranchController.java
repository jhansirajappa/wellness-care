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
import org.springframework.web.bind.annotation.RestController;

import com.ty.wellness_care.dto.Branch;
import com.ty.wellness_care.service.BranchService;
import com.ty.wellness_care.util.ResponseStructure;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;

	@PostMapping("hospital/branch")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);

	}

	@PutMapping("hospital/branch/{branchid}")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch, @PathVariable int id) {
		return branchService.updateBranch(id, branch);
	}

	@GetMapping("hospital/branch")
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranch() {
		return branchService.getAllBranch();
	}

	@GetMapping("hospital/branch/{branchid}")
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(@PathVariable int id) {
		return branchService.getBranchById(id);
	}

	@GetMapping("hospital/{hospitalid}/branch")
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByHospital(int hospitalid) {
		return branchService.getBranchByHospital(hospitalid);
	}

	@DeleteMapping("hospital/branch")
	public ResponseEntity<ResponseStructure<String>> deleteBranch(int id) {
		return branchService.deleteBranch(id);
	}

}
