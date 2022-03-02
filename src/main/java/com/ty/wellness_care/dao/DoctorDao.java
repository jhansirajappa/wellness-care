package com.ty.wellness_care.dao;

import java.util.List;

import com.ty.wellness_care.dto.Doctor;

public interface DoctorDao {

	public Doctor saveDoctor(Doctor doctor);

	public Doctor updateDoctor(int id, Doctor doctor);

	public List<Doctor> getAllDoctor();

	public Doctor getDoctorById(int id);

	public List<Doctor> getDoctorByHospital(int hospitalid);

	public boolean deleteDoctor(int id);

}
