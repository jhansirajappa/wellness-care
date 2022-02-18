package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.Branch;
import com.ty.wellness_care.service.BranchService;
import com.ty.wellness_care.util.ResponseStructure;

public class BranchServiceImpl implements BranchService {

	@Override
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id, Branch Branch) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByHospital(int hospitalid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteBranch(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
