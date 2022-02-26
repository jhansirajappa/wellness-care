package com.ty.wellness_care.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.wellness_care.dao.DoctorDao;
import com.ty.wellness_care.dto.Doctor;
import com.ty.wellness_care.repository.DoctorRepository;

@Repository
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public Doctor saveDoctor(Doctor doctor) {

		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor updateDoctor(int id, Doctor doctor) {
		Doctor doctor2 = getDoctorById(id);
		if (doctor2 != null) {
			doctor.setId(id);
			return doctorRepository.save(doctor);
		}
		return null;
	}

	@Override
	public List<Doctor> getAllDoctor() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getDoctorById(int id) {
		return doctorRepository.getById(id);
	}

	@Override
	public List<Doctor> getDoctorByHospital(int hospitalid) {
		return doctorRepository.getDoctorByHospital(hospitalid);
	}

	@Override
	public boolean deleteDoctor(int id) {
		Doctor doctor = getDoctorById(id);
		if (doctor != null) {
			doctor.setId(id);
			doctorRepository.delete(doctor);
			return true;
		}
		return false;
	}

	@Override
	public List<Doctor> getDoctorBySchedule(int hospitalid) {
		return doctorRepository.getDoctorBySchedule(hospitalid);

	}

}
