package com.ty.wellness_care.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.wellness_care.dto.Lab;

public interface LabRepository extends JpaRepository<Lab, Integer> {

	@Query("Select s from Lab s where s.branch.id=?1 ")
	public List<Lab> getLabByBranch(int id);
}
