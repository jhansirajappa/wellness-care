package com.ty.wellness_care.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.wellness_care.dto.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

	@Query("Select s from Schedule s where s.branch.id=?1 ")
	public List<Schedule> getScheduleByBranch(int branchId);

	@Query("Select s from Schedule s where s.doctor.id=?1 ")
	public List<Schedule> getScheduleByDoctor(int doctorId);
}
