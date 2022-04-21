package com.ty.wellness_care.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.Lab;
import com.ty.wellness_care.util.ResponseStructure;

public interface LabService {

	public ResponseEntity<ResponseStructure<Lab>> saveLab(Lab lab);

	public ResponseEntity<ResponseStructure<Lab>> getLabById(int id);

	public ResponseEntity<ResponseStructure<List<Lab>>> getAllLab();

	public ResponseEntity<ResponseStructure<Lab>> updateLab(Lab lab, int id);

	public ResponseEntity<ResponseStructure<String>> deleteLab(int id);

	public ResponseEntity<ResponseStructure<List<Lab>>> getLabByBranch(int id);

}
