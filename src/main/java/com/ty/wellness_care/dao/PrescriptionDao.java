package com.ty.wellness_care.dao;

import java.util.List;

import com.ty.wellness_care.dto.Prescription;


public interface PrescriptionDao {


	public Prescription savePrescription(Prescription prescription);
	public Prescription updatePrescription(int id,Prescription prescription);
	public List<Prescription> getAllPrescription();
	public List<Prescription> getPrescriptionByDoctor( int doctorid);
	public List<Prescription> getPrescriptionById(int prescriptionId);
	public String deletePrescription(int id);

}
