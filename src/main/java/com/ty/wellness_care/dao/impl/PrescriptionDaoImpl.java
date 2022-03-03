package com.ty.wellness_care.dao.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.wellness_care.dao.PrescriptionDao;
import com.ty.wellness_care.dto.Branch;
import com.ty.wellness_care.dto.Prescription;
import com.ty.wellness_care.repository.PrescriptionRepository;

@Repository
public class PrescriptionDaoImpl implements PrescriptionDao {

	@Autowired
	PrescriptionRepository prescriptionRepository;

	@Override
	public Prescription savePrescription(Prescription prescription) {
		return prescriptionRepository.save(prescription);
	}

	@Override
	public Prescription updatePrescription(int id, Prescription prescription) {
		Prescription prescription2 = getPrescriptionById(id);
		if (prescription2 != null) {
			prescription.setId(id);
			return prescriptionRepository.save(prescription);
		}
		return null;
	}

	@Override
	public List<Prescription> getAllPrescription() {
		return prescriptionRepository.findAll();
	}

	@Override
	public List<Prescription> getPrescriptionByDoctor(int doctorid) {
		return prescriptionRepository.getPrescriptionByDoctor(doctorid);
	}

	@Override
	public Prescription getPrescriptionById(int prescriptionId) {
	
		Optional<Prescription> optional = prescriptionRepository.findById(prescriptionId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
		
	}

	@Override
	public boolean deletePrescription(int id) {
		Prescription prescription2 = getPrescriptionById(id);
		System.out.println(prescription2);
		if (prescription2 != null) {
			prescriptionRepository.delete(prescription2);
			return true;
		}
		return false;

	}

}
