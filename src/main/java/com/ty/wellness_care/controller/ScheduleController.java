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
import com.ty.wellness_care.service.ScheduleService;
import com.ty.wellness_care.util.ResponseStructure;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ScheduleController {

	@Autowired 
	ScheduleService service;

	@PostMapping("doctor/schedule")
	@ApiResponses({@ApiResponse(code=200,message="Schedule Saved"),
		@ApiResponse(code=404,message = "Schedule not saved"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Schedule>> saveSchedule(@RequestBody Schedule schedule) {
		return service.saveSchedule(schedule);
	}

	@GetMapping("doctor/schedule/{scheduleid}")
	@ApiResponses({@ApiResponse(code=200,message="get Schedule by Id"),
		@ApiResponse(code=404,message = "Schedule not found"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Schedule>> getScheduleById(@PathVariable int scheduleid) {
		return service.getScheduleById(scheduleid);
	}

	@GetMapping("doctor/schedule")
	@ApiResponses({@ApiResponse(code=200,message="get all Schedules"),
		@ApiResponse(code=404,message = "no Schedule found"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Schedule>>> getAllSchedules() {
		return service.getAllSchedules();
	}

	@GetMapping("branch/{branchid}/schedule")
	@ApiResponses({@ApiResponse(code=200,message="get Schedule by branch id"),
		@ApiResponse(code=404,message = "Branch Id not found"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Schedule>>> getScheduleByBranch(@PathVariable int branchid) {
		return service.getScheduleByBranch(branchid);
	}

	@GetMapping("doctor/{doctorid}/schedule")
	@ApiResponses({@ApiResponse(code=200,message="Admin retrieved"),
		@ApiResponse(code=404,message = "Admin not retrieved"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Schedule>>> getScheduleByDoctor(@PathVariable int doctorid) {
		return service.getScheduleByDoctor(doctorid);
	}

	@PutMapping("doctor/schedule/{scheduleid}")
	@ApiResponses({@ApiResponse(code=200,message="Schedule updated"),
		@ApiResponse(code=404,message = "Schedule not updated"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Schedule>> updateSchedule(@RequestBody Schedule schedule,
			@PathVariable int scheduleid) {
		return service.updateSchedule(scheduleid, schedule);
	}

	@DeleteMapping("doctor/schedule")
	@ApiResponses({@ApiResponse(code=200,message="Schedule deleted"),
		@ApiResponse(code=404,message = "Schedule not retrieved"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<String>> deleteSchedule(@RequestParam int id) {
		return service.deleteSchedule(id);
	}
}
