package com.ty.wellness_care.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ty.wellness_care.dao.MedOrderDao;
import com.ty.wellness_care.dao.impl.DoctorDaoImpl;
import com.ty.wellness_care.dao.impl.LabDaoImpl;
import com.ty.wellness_care.dao.impl.MedOrderDaoImpl;
import com.ty.wellness_care.dto.Lab;
import com.ty.wellness_care.dto.MedOrder;
import com.ty.wellness_care.dto.Prescription;
import com.ty.wellness_care.service.impl.PrescriptionServiceImpl;

public class Demo {

	public static void main(String[] ar0gs) {

		Prescription prescription = new Prescription();
		prescription.setDateTime(LocalDateTime.now());
		MedOrderDao dao = new MedOrderDaoImpl();
		MedOrder medOrder1 = new MedOrder();
		medOrder1.setCost(100);
		MedOrder medOrder2 = new MedOrder();
		medOrder1.setCost(200);
		MedOrder medOrder3 = new MedOrder();
		medOrder1.setCost(300);
		List<MedOrder> medOrders = new ArrayList<MedOrder>();
		medOrders.add(medOrder3);
		medOrders.add(medOrder2);
		medOrders.add(medOrder1);
	
		List<Lab> labs = new ArrayList<Lab>();
		Lab lab1 = new Lab();
		lab1.setFees(1000);
		Lab lab2 = new Lab();
		lab2.setFees(1500);
		Lab lab3 = new Lab();
		lab3.setFees(1800);
		labs.add(lab1);
		labs.add(lab3);
		labs.add(lab2);
		labs.add(lab1);
//		prescription.setLabs(labs);
		prescription.setPatientMail("pradeepaselvanesan@gmail.com");
		prescription.setDoctorName("Jhon");
		PrescriptionServiceImpl impl = new PrescriptionServiceImpl();
		impl.savePrescription(prescription);
	}
}
