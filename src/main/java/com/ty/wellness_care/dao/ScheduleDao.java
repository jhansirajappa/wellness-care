package com.ty.wellness_care.dao;

import java.util.List;

import com.ty.wellness_care.dto.Schedule;
import com.ty.wellness_care.dto.User;

public interface ScheduleDao {

	Schedule saveSchedule(Schedule schedule);
	Schedule updateSchedule(int id,Schedule schedule);
	List<Schedule> getAllSchedules();
	boolean deleteSchedule(int id);
	User getScheduleById(int id);
}
