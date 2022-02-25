package com.ty.wellness_care.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.wellness_care.dto.Branch;
import com.ty.wellness_care.dto.Prescription;

public interface BranchRepository extends JpaRepository<Branch, Integer>{

	@Query("select b from Branch b where b.hospital.id=?1")
	public List<Branch> getBranchByHospital(int hospitalid);
}
