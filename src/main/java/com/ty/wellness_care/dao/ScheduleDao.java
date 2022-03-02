package com.ty.wellness_care.dao;

import java.util.List;

import com.ty.wellness_care.dto.Schedule;

public interface ScheduleDao {

	Schedule saveSchedule(Schedule schedule);

	Schedule updateSchedule(int id, Schedule schedule);

	List<Schedule> getAllSchedules();

	boolean deleteSchedule(int id);

	Schedule getScheduleById(int id);

	List<Schedule> getScheduleByBranch(int hospitalId);

	List<Schedule> getScheduleByDoctor(int doctorId);

}
