package com.ty.wellness_care.dao;

import java.util.List;

import com.ty.wellness_care.dto.Hospital;


public interface HospitalDao {
	public Hospital saveHospital(Hospital hospital);
	public Hospital updateHospital(int id,Hospital hospital);
	public List<Hospital> getAllHospital();
	public List<Hospital> getHospitalById( int id);
	public List<Hospital> getHospitalByAdmin(int adminid);
	public String deleteHospital(int id);

}
