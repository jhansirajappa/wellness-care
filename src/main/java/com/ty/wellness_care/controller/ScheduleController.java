package com.ty.wellness_care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.wellness_care.dto.Schedule;
import com.ty.wellness_care.dto.User;
import com.ty.wellness_care.service.ScheduleService;
import com.ty.wellness_care.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ScheduleController {

	@Autowired
	ScheduleService service;
	
	@PostMapping("doctor/schedule")
	public ResponseEntity<ResponseStructure<Schedule>> saveSchedule(@RequestBody Schedule schedule) {
		return null;
	}
	
	@GetMapping("doctor/{doctorid}/schedule/{scheduleid}")
	public ResponseEntity<ResponseStructure<Schedule>> getScheduleById(@PathVariable int scheduleid,@PathVariable int doctorid) {
		return null;
}
	@GetMapping("doctor/schedule")
	public  ResponseEntity<ResponseStructure<List<Schedule>>> getAllSchedules() {
		return null;
}
	@PutMapping("doctor/{doctorid}/schedule/{scheduleid}") 
	public ResponseEntity<ResponseStructure<Schedule>> upddateSchedule(@RequestBody Schedule schedule,@PathVariable int scheduleid,@PathVariable int doctorid) {
		return null;
	
	}
		@DeleteMapping("doctor/schedule")
		public ResponseEntity<ResponseStructure<String>> deleteSchedule(@RequestParam int id) {
			return null;
		}
}
