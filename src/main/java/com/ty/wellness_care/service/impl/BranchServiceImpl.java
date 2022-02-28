package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.wellness_care.dao.BranchDao;
import com.ty.wellness_care.dto.Branch;
import com.ty.wellness_care.dto.Hospital;
import com.ty.wellness_care.exception.IDNotFoundException;
import com.ty.wellness_care.service.BranchService;
import com.ty.wellness_care.util.ResponseStructure;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	BranchDao branchDao;
	@Override
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(branchDao.saveBranch(branch));
		ResponseEntity<ResponseStructure<Branch>> responseEntity=new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id, Branch branch) {
		Branch branch2= branchDao.updateBranch(id, branch);
		
		if(branch2 != null) {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(branch2);
		ResponseEntity<ResponseStructure<Branch>> responseEntity=new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		return responseEntity;
		}
		else {
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("not found");
		responseStructure.setData(null);
		ResponseEntity<ResponseStructure<Branch>> responseEntity=new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.NOT_FOUND);
		
		return responseEntity;
			
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Branch>>> getAllBranch() {
		List<Branch> branchs=branchDao.getAllBranch();
		if(branchs != null) {
			
		
		ResponseStructure<List<Branch>> responseStructure=new ResponseStructure<List<Branch>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(branchs);
		ResponseEntity<ResponseStructure<List<Branch>>> responseEntity=new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure,HttpStatus.OK);
		
		return responseEntity;
		}
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int id) {
		Branch hospital=branchDao.getBranchById(id);
		if(hospital != null) {
			
		
		ResponseStructure<Branch> responseStructure=new ResponseStructure<Branch>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(branchDao.getBranchById(id));
		ResponseEntity<ResponseStructure<Branch>> responseEntity=new ResponseEntity<ResponseStructure<Branch>>(responseStructure,HttpStatus.OK);
		
		return responseEntity;
	}
		throw new IDNotFoundException(" Branch id"+id+"not found");
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Branch>>> getBranchByHospital(int hospitalid) {
		List<Branch> branchs=branchDao.getBranchByHospital(hospitalid);
		if(branchs != null) {
			
		
		ResponseStructure<List<Branch>> responseStructure=new ResponseStructure<List<Branch>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(branchDao.getBranchByHospital(hospitalid));
		ResponseEntity<ResponseStructure<List<Branch>>> responseEntity=new ResponseEntity<ResponseStructure<List<Branch>>>(responseStructure,HttpStatus.OK);
		return responseEntity;
	}
		throw new IDNotFoundException(" Branch id"+hospitalid+"not found");
	}
	

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteBranch(int id) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity=null;
		if(branchDao.deleteBranch(id)) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData("Branch deleted");
		responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
		return responseEntity;
	}
		else {
			throw new IDNotFoundException(" Branch id"+id+"not found");
		}
	}

}
