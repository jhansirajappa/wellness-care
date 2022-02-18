package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.Bed;
import com.ty.wellness_care.service.BedService;
import com.ty.wellness_care.util.ResponseStructure;

public class BedServiceImpl implements BedService{

	@Override
	public ResponseEntity<ResponseStructure<Bed>> saveBed(Bed bed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Bed>> updateBed(int id, Bed bed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Bed>>> getAllBed() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Bed>>> getBedById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Bed>>> getBedByRoom(int roomid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteBed(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
