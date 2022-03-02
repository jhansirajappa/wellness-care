package com.ty.wellness_care.dao;

import java.util.List;

import com.ty.wellness_care.dto.Branch;

public interface BranchDao {

	public Branch saveBranch(Branch branch);
	public Branch updateBranch(int id,Branch branch);
	public List<Branch> getAllBranch();
	public Branch getBranchById( int id);
	public List<Branch> getBranchByHospital(int hospitalid);
	public boolean deleteBranch(int id);

}
