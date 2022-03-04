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

import com.ty.wellness_care.dto.Floor;
import com.ty.wellness_care.service.FloorService;
import com.ty.wellness_care.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class FloorController {

	@Autowired
	FloorService floorService;
	
	@PostMapping("branch/floor")
	@ApiOperation("To Save Floor")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Floor>> saveFloor(@RequestBody Floor floor) {
		return floorService.saveFloor(floor);
	}

	@PutMapping("branch/floor/{floorid}")
	@ApiOperation("To Update Floor By Id")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Floor>> updateFloor(@RequestBody Floor floor,@PathVariable int floorid) {
		return floorService.updateFloor(floorid, floor);
	}

	@GetMapping("branch/floor")
	@ApiOperation("To Get Floors")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Floor>>> getAllFloor() {
		return floorService.getAllFloor();
	}

	@GetMapping("branch/floor/{floorid}")
	@ApiOperation("To Get Floor By Id")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Floor>> getFloorById(@PathVariable int floorid) {
		return floorService.getFloorById(floorid);
	}

	@GetMapping("branch/{branchid}/floor")
	@ApiOperation("To Get Floor By Branch Id ")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Floor>>> getFloorByBranch(@PathVariable int branchid) {
		return floorService.getFloorByBranch(branchid);
	}

	@DeleteMapping("branch/floor")
	@ApiOperation("To Delete Floor By Id")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<String>> deleteFloor(@RequestParam int id) {
		return floorService.deleteFloor(id);
	}

}
