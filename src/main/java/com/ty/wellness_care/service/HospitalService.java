package com.ty.wellness_care.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.Hospital;
import com.ty.wellness_care.util.ResponseStructure;

public interface HospitalService {

	public ResponseEntity<ResponseStructure<Hospital>>  saveHospital(Hospital hospital);
	public ResponseEntity<ResponseStructure<Hospital>>  updateHospital(int id,Hospital hospital);
	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital();
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById( int id);
	public ResponseEntity<ResponseStructure<String>> deleteHospital(int id);
}
