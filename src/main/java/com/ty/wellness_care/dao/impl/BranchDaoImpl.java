package com.ty.wellness_care.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ty.wellness_care.dao.BranchDao;
import com.ty.wellness_care.dto.Branch;
import com.ty.wellness_care.dto.Room;
import com.ty.wellness_care.repository.BranchRepositry;

@Repository
public class BranchDaoImpl implements BranchDao{

	@Autowired
	BranchRepositry repositry;
	
	@Override
	public Branch saveBranch(Branch branch) {
		return repositry.save(branch);
	}

	@Override
	public Branch updateBranch(int id, Branch branch) {
		if (getBranchById(id) != null) {
			branch.setId(id);
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
    @Query("select b from Branch b where hospital")
	public Branch getBranchByHospital(int hospitalid) {
		Optional<Branch> optional = repositry.findById(hospitalid);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
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
