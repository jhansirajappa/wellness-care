package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.wellness_care.dao.HospitalDao;
import com.ty.wellness_care.dto.Hospital;
import com.ty.wellness_care.exception.HospitalNotFoundException;
import com.ty.wellness_care.service.HospitalService;
import com.ty.wellness_care.util.ResponseStructure;

@Service
public class HospitalServiceImpl implements HospitalService{

	@Autowired
	HospitalDao hospitalDao;
	
	@Override
	public  ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(hospitalDao.saveHospital(hospital));
		ResponseEntity<ResponseStructure<Hospital>> responseEntity=new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id,Hospital hospital) {
	Hospital hospitalid=hospitalDao.getHospitalById(id);
		if(hospitalid != null) {
			hospital.setId(hospitalid.getId());
			hospitalDao.updateHospital(id, hospital);
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(hospital);
		ResponseEntity<ResponseStructure<Hospital>> responseEntity=new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		return responseEntity;
	}
		else {
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("not found");
		responseStructure.setData(null);
		ResponseEntity<ResponseStructure<Hospital>> responseEntity=new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.NOT_FOUND);
		
		return responseEntity;
			
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Hospital>>> getAllHospital() {
		List<Hospital> hospital=hospitalDao.getAllHospital();
		if(hospital != null) {
			
		ResponseStructure<List<Hospital>> responseStructure=new ResponseStructure<List<Hospital>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(hospital);
		ResponseEntity<ResponseStructure<List<Hospital>>> responseEntity=new ResponseEntity<ResponseStructure<List<Hospital>>>(responseStructure,HttpStatus.OK);
		
		return responseEntity;
		}
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteHospital(int id) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity=null;
		if(hospitalDao.deleteHospital(id)) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData("Hospital deleted");
		responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
		return responseEntity;
	}
		else {
			throw new HospitalNotFoundException(" Hospital id"+id+"not found");
		}

}
	@Override
	public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id) {
		
		Hospital hospital=hospitalDao.getHospitalById(id);
		if(hospital != null) {
			
		
		ResponseStructure<Hospital> responseStructure=new ResponseStructure<Hospital>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(hospitalDao.getHospitalById(id));
		ResponseEntity<ResponseStructure<Hospital>> responseEntity=new ResponseEntity<ResponseStructure<Hospital>>(responseStructure,HttpStatus.OK);
		
		return responseEntity;
	}
		throw new HospitalNotFoundException(" Hospital id"+id+"not found");
			
		}

	@Override
	public ResponseEntity<ResponseStructure<List<Hospital>>> getHospitalByAdmin(int adminid) {
		List<Hospital> hospitals=hospitalDao.getHospitalByAdmin(adminid);
		if(hospitals != null) {
			
		
		ResponseStructure<List<Hospital>> responseStructure=new ResponseStructure<List<Hospital>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(hospitalDao.getHospitalByAdmin(adminid));
		ResponseEntity<ResponseStructure<List<Hospital>>> responseEntity=new ResponseEntity<ResponseStructure<List<Hospital>>>(responseStructure,HttpStatus.OK);
		return responseEntity;
	}
		throw new HospitalNotFoundException(" Hospital id"+adminid+"not found");
	}
	}