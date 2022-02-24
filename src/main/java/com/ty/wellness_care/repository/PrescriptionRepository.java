package com.ty.wellness_care.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.wellness_care.dto.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer>{

	@Query("select p from Prescription p where p.doctor.id=?1")
	public List<Prescription> getPrescriptionByDoctor(int doctorid);
		
	
}
