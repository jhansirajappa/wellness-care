package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.wellness_care.dao.ScheduleDao;
import com.ty.wellness_care.dto.Schedule;
import com.ty.wellness_care.exception.IDNotFoundException;
import com.ty.wellness_care.service.ScheduleService;
import com.ty.wellness_care.util.ResponseStructure;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	@Autowired
	ScheduleDao dao;

	@Override
	public ResponseEntity<ResponseStructure<Schedule>> saveSchedule(Schedule schedule) {
		ResponseStructure<Schedule> responseStructure = new ResponseStructure<Schedule>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(dao.saveSchedule(schedule));
		ResponseEntity<ResponseStructure<Schedule>> responseEntity = new ResponseEntity<ResponseStructure<Schedule>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Schedule>> updateSchedule(int id, Schedule schedule) {
		ResponseStructure<Schedule> responseStructure = new ResponseStructure<Schedule>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(dao.updateSchedule(id, schedule));
		ResponseEntity<ResponseStructure<Schedule>> responseEntity = new ResponseEntity<ResponseStructure<Schedule>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Schedule>>> getAllSchedules() {
		ResponseStructure<List<Schedule>> responseStructure = new ResponseStructure<List<Schedule>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(dao.getAllSchedules());
		ResponseEntity<ResponseStructure<List<Schedule>>> responseEntity = new ResponseEntity<ResponseStructure<List<Schedule>>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteSchedule(int id) {
		if (dao.deleteSchedule(id)) {
			ResponseStructure<String> responseStructure = new ResponseStructure<String>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData("Schedule Deleted");
			ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
					responseStructure, HttpStatus.OK);
			return responseEntity;

		} else {
			throw new IDNotFoundException("Schedule Id: " + id + " not found/exists");

		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Schedule>> getScheduleById(int id) {
		ResponseStructure<Schedule> responseStructure = new ResponseStructure<Schedule>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(dao.getScheduleById(id));
		ResponseEntity<ResponseStructure<Schedule>> responseEntity = new ResponseEntity<ResponseStructure<Schedule>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;

	}

	@Override
	public ResponseEntity<ResponseStructure<List<Schedule>>> getScheduleByBranch(int hospitalId) {
		ResponseStructure<List<Schedule>> responseStructure = new ResponseStructure<List<Schedule>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(dao.getScheduleByBranch(hospitalId));
		ResponseEntity<ResponseStructure<List<Schedule>>> responseEntity = new ResponseEntity<ResponseStructure<List<Schedule>>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Schedule>>> getScheduleByDoctor(int doctorId) {
		ResponseStructure<List<Schedule>> responseStructure = new ResponseStructure<List<Schedule>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(dao.getScheduleByDoctor(doctorId));
		ResponseEntity<ResponseStructure<List<Schedule>>> responseEntity = new ResponseEntity<ResponseStructure<List<Schedule>>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}

}
