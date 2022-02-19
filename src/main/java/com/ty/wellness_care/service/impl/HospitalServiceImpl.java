package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.Hospital;
import com.ty.wellness_care.service.HospitalService;
import com.ty.wellness_care.util.ResponseStructure;

public class HospitalServiceImpl implements HospitalService{

	@Override
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id, Hospital hospital) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Hospital>>> getHospitalById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Hospital>>> getHospitalByAdmin(int adminid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteHospital(int id) {
		// TODO Auto-generated method stub
		return null;
	}



}
