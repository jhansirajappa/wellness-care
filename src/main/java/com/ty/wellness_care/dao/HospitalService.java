package com.ty.wellness_care.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.Hospital;
import com.ty.wellness_care.util.ResponseStructure;

public interface HospitalService {

	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital);
	public ResponseEntity<ResponseStructure<Hospital>> updateDoctor(int id,Hospital hospital);
	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital();
	public ResponseEntity<ResponseStructure<List<Hospital>>> getHospitalById( int id);
	public ResponseEntity<ResponseStructure<List<Hospital>>> getHospitalByAdmin(int adminid);
	public String deleteHospital(int id);
}
