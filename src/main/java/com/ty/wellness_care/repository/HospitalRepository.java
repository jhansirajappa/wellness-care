package com.ty.wellness_care.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.wellness_care.dto.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

	@Query("select h from Hospital h where h.admin.id=?1")
	List<Hospital> getHospitalByAdmin(int adminid);

}
