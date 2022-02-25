package com.ty.wellness_care.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.wellness_care.dao.HospitalDao;
import com.ty.wellness_care.dto.Hospital;
import com.ty.wellness_care.repository.HospitalRepositry;

@Repository
public class HospitalDaoImpl implements HospitalDao{

	@Autowired
	HospitalRepositry repositry;
	
	@Override
	public Hospital saveHospital(Hospital hospital) {
		return repositry.save(hospital);
	}

	@Override
	public Hospital updateHospital(int id, Hospital hospital) {
		if (getHospitalById(id) != null) {
			hospital.setId(id);
			return repositry.save(hospital);
		}
		return null;
	}

	@Override
	public List<Hospital> getAllHospital() {
	
		return repositry.findAll();
	}

	@Override
	public Hospital getHospitalById(int id) {
		Optional<Hospital> optional = repositry.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Hospital> getHospitalByAdmin(int adminid) {
		
		return null;
	}

	@Override
	public boolean deleteHospital(int id) {
		Hospital hospital = getHospitalById(id);
		if (hospital != null) {
			repositry.delete(hospital);
			return true;
		}
		return false;
	}

}
