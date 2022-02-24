package com.ty.wellness_care.dao;

import java.util.List;

import com.ty.wellness_care.dto.MedOrder;

public interface MedOrderDao {

	public MedOrder saveMedOrder(MedOrder medOrder);

	public MedOrder updateMedOrder(int id, MedOrder medOrder);

	public List<MedOrder> getAllMedOrders();

	public MedOrder getMedOrderById(int id);

	public List<MedOrder> getMedOrderByPrescription(int prescriptionId);

	public boolean deleteMedOrder(int id);

}
