package com.ty.wellness_care.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.Schedule;
import com.ty.wellness_care.util.ResponseStructure;

public interface ScheduleService {

	public ResponseEntity<ResponseStructure<Schedule>> saveSchedule(Schedule schedule);

	public ResponseEntity<ResponseStructure<Schedule>> updateSchedule(int id, Schedule schedule);

	public ResponseEntity<ResponseStructure<List<Schedule>>> getAllSchedules();

	public ResponseEntity<ResponseStructure<String>> deleteSchedule(int id);

	public ResponseEntity<ResponseStructure<Schedule>> getScheduleById(int id);

	public ResponseEntity<ResponseStructure<List<Schedule>>> getScheduleByBranch(int hospitalId);

	public ResponseEntity<ResponseStructure<List<Schedule>>> getScheduleByDoctor(int doctorId);

}
