package com.ty.wellness_care.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.wellness_care.dao.LabDao;
import com.ty.wellness_care.dto.Lab;
import com.ty.wellness_care.repository.LabRepository;

@Repository
public class LabDaoImpl implements LabDao {

	@Autowired
	LabRepository labRepository;

	@Override
	public Lab saveLab(Lab lab) {
		return labRepository.save(lab);
	}

	@Override
	public Lab updateLab(int id, Lab lab) {
		Lab existingLab = getLabById(id);
		if (existingLab != null) {
			existingLab.setTestName(lab.getTestName());
			existingLab.setReportingDoctor(lab.getReportingDoctor());
			existingLab.setLocation(lab.getLocation());
			existingLab.setFees(lab.getFees());
			existingLab.setEmail(lab.getEmail());
			existingLab.setPassword(lab.getPassword());
			return existingLab;
		}
		return null;
	}

	@Override
	public List<Lab> getAllLabs() {
		return labRepository.findAll();
	}

	@Override
	public boolean deleteLab(int id) {
		Lab lab = getLabById(id);
		if (lab != null) {
			labRepository.delete(lab);
			return true;
		}
		return false;
	}

	@Override
	public List<Lab> getLabByBranch(int id) {
		return labRepository.getLabByBranch(id);
	}

	@Override
	public Lab getLabById(int id) {
		Optional<Lab> optional = labRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
