package com.ty.wellness_care.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.wellness_care.dao.ScheduleDao;
import com.ty.wellness_care.dto.Schedule;
import com.ty.wellness_care.repository.ScheduleRepository;

@Repository
public class ScheduleDaoImpl implements ScheduleDao {

	@Autowired
	ScheduleRepository repository;

	@Override
	public Schedule saveSchedule(Schedule schedule) {
		return repository.save(schedule);
	}

	@Override
	public Schedule updateSchedule(int id, Schedule schedule) {
		Schedule schedule2 = getScheduleById(id);
		if (schedule2 != null) {
			schedule.setId(schedule2.getId());
			return repository.save(schedule);
		}
		return null;
	}

	@Override
	public List<Schedule> getAllSchedules() {
		return repository.findAll();
	}

	@Override
	public boolean deleteSchedule(int id) {
		Schedule schedule = getScheduleById(id);
		if (schedule != null) {
			repository.delete(schedule);
			return true;
		}
		return false;
	}

	@Override
	public Schedule getScheduleById(int id) {
		Optional<Schedule> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Schedule> getScheduleByBranch(int hospitalId) {
		return repository.getScheduleByBranch(hospitalId);
	}

	@Override
	public List<Schedule> getScheduleByDoctor(int doctorId) {
		return repository.getScheduleByDoctor(doctorId);
	}

//	@Override
//	public com.ty.wellness_care.dao.Schedule saveSchedule(com.ty.wellness_care.dao.Schedule schedule) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public com.ty.wellness_care.dao.Schedule updateSchedule(int id, com.ty.wellness_care.dao.Schedule schedule) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	

}
