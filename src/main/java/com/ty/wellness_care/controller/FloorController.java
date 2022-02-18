package com.ty.wellness_care.controller;

import java.util.List;

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
import com.ty.wellness_care.util.ResponseStructure;

@RestController
public class FloorController {

	@PostMapping("branch/floor")
	public ResponseEntity<ResponseStructure<Floor>> saveFloor(@RequestBody Floor floor) {
		// TODO Auto-generated method stub
		return null;
	}

	@PutMapping("branch/floor/{floorid}")
	public ResponseEntity<ResponseStructure<Floor>> updateFloor(@PathVariable int floorid,@RequestBody Floor floor) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("branch/floor")
	public ResponseEntity<ResponseStructure<List<Floor>>> getAllFloor() {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("branch/floor/{floorid}")
	public ResponseEntity<ResponseStructure<List<Floor>>> getFloorById(@PathVariable int floorid) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("branch/{branchid}/floor")
	public ResponseEntity<ResponseStructure<List<Floor>>> getFloorByBranch(@PathVariable int branchid) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("branch/floor")
	public String deleteFloor(@RequestParam int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
