package com.ty.wellness_care.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.wellness_care.dao.BranchDao;
import com.ty.wellness_care.dto.Bed;
import com.ty.wellness_care.dto.Branch;
import com.ty.wellness_care.repository.BranchRepository;

@Repository
public class BranchDaoImpl implements BranchDao{

	@Autowired
	BranchRepository repositry;
	
	@Override
	public Branch saveBranch(Branch branch) {
		return repositry.save(branch);
	}

	@Override
	public Branch updateBranch(int id, Branch branch) {
		Branch branch2=getBranchById(id);
		if (branch2 != null) {
			branch.setId(branch2.getId());
			return repositry.save(branch);
		}
		return null;
	}

	@Override
	public List<Branch> getAllBranch() {
	
		return repositry.findAll();
	}

	@Override
	public Branch getBranchById(int id) {
		Optional<Branch> optional = repositry.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Branch> getBranchByHospital(int hospitalid) {
	return repositry.getBranchByHospital(hospitalid);
	}

	@Override
	public boolean deleteBranch(int id) {
		Branch branch = getBranchById(id);
		if (branch != null) {
			repositry.delete(branch);
			return true;
		}
		return false;
	}

}
