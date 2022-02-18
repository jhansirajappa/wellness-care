package com.ty.wellness_care.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.Branch;
import com.ty.wellness_care.util.ResponseStructure;

public interface BranchService {


	public ResponseEntity<ResponseStructure<Branch>>  saveBranch(Branch branch);
	public ResponseEntity<ResponseStructure<Branch>>  updateBranch(int id,Branch Branch);
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranch();
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchById( int id);
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByHospital(int hospitalid);
	public ResponseEntity<ResponseStructure<String>> deleteBranch(int id);

}
