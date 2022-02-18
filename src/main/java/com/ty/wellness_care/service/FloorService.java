package com.ty.wellness_care.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.Floor;
import com.ty.wellness_care.util.ResponseStructure;

public interface FloorService {

	public ResponseEntity<ResponseStructure<Floor>>  saveFloor(Floor floor);
	public ResponseEntity<ResponseStructure<Floor>>  updateFloor(int id,Floor floor);
	public ResponseEntity<ResponseStructure<List<Floor>>> getAllFloor();
	public ResponseEntity<ResponseStructure<List<Floor>>> getFloorById( int id);
	public ResponseEntity<ResponseStructure<List<Floor>>> getFloorByBranch(int branchid);
	public ResponseEntity<ResponseStructure<String>> deleteFloor(int id);


}
