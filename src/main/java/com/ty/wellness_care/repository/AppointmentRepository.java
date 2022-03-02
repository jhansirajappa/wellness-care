package com.ty.wellness_care.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.wellness_care.dto.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>{

	@Query("Select a from Appointment a where a.user.id=?1")
	public List<Appointment> getAppointmentByUser(int userId);
	

	@Query("Select a from Appointment a where a.branch.id=?1")
	public List<Appointment> getAppointmentByBranch(int userId);
	
	@Query("Select a from Appointment a where a.doctor.id=?1")
	public List<Appointment> getAppointmentByDoctor(int userId);
	
	
}
