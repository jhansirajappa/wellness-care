package com.ty.wellness_care.dao;

import java.util.List;

import com.ty.wellness_care.dto.Lab;

public interface LabDao {

	Lab saveLab(Lab lab);

	Lab updateLab(int id, Lab lab);

	List<Lab> getAllLabs();

	boolean deleteLab(int id);

	List<Lab> getLabByBranch(int id);

	Lab getLabById(int id);
}
