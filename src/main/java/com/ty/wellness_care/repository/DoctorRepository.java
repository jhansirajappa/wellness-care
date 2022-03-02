package com.ty.wellness_care.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.wellness_care.dto.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	@Query("Select d from Doctor d where d.hospital.id=?1")
	public List<Doctor> getDoctorByHospital(int hospitalid);

}
