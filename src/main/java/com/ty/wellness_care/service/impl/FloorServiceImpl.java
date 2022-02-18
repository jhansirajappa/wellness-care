package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.Floor;
import com.ty.wellness_care.service.FloorService;
import com.ty.wellness_care.util.ResponseStructure;

public class FloorServiceImpl implements FloorService {

	@Override
	public ResponseEntity<ResponseStructure<Floor>> saveFloor(Floor floor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Floor>> updateFloor(int id, Floor floor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Floor>>> getAllFloor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Floor>>> getFloorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Floor>>> getFloorByBranch(int branchid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteFloor(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
