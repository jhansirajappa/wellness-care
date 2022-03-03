package com.ty.wellness_care.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.Doctor;
import com.ty.wellness_care.util.ResponseStructure;

public interface DoctorService {

	public ResponseEntity<ResponseStructure<Doctor>> saveDoctor(Doctor doctor);

	public ResponseEntity<ResponseStructure<Doctor>> updateDoctor(int id,Doctor doctor);

	public ResponseEntity<ResponseStructure<List<Doctor>>> getAllDoctor();

	public ResponseEntity<ResponseStructure<Doctor>> getDoctorById(int id);

	public ResponseEntity<ResponseStructure<List<Doctor>>> getDoctorByHospital(int hospitalid);

	public ResponseEntity<ResponseStructure<String>> deleteMedOrder(int id);


}
