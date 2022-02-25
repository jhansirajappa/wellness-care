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

import com.ty.wellness_care.dto.Hospital;
import com.ty.wellness_care.service.HospitalService;
import com.ty.wellness_care.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HospitalController {


	@Autowired
	HospitalService hospitalService;
	
	@PostMapping("admin/hospital")
	@ApiOperation("To Save Hospital")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public  ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}
	
	@GetMapping("admin/hospital")
	@ApiOperation("To Get All Hospitals")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital() {
		return hospitalService.getAllHospital();
	}

	@GetMapping("admin/hospital/{id}")
	@ApiOperation("To Get Hospital By Id")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(@ApiParam("ID to get Hospital")  @PathVariable ("id")int id) {
	return hospitalService.getHospitalById(id);
	}
	
	@PutMapping("admin/hospital/{id}")
	@ApiOperation("To Update Hospital By Id")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Hospital>> updateUser(@RequestParam int id,@RequestBody Hospital hospital) {
		return hospitalService.updateHospital(id,hospital);
	}
	
	@DeleteMapping("admin/hospital/{id}")
	@ApiOperation("To Delete Hospital By Id")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<String>> deleteHospital(@RequestParam int id) {
		return hospitalService.deleteHospital(id);
	}

	@GetMapping("admin/{adminid}/hospital")
	@ApiOperation("To Get hospital By Admin Id")
	@ApiResponses({@ApiResponse(code=200,message="Retrived Hospital"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Hospital>>> getHospitalByAdmin(@PathVariable int adminid) {
		return hospitalService.getHospitalByAdmin(adminid);
	}


}
