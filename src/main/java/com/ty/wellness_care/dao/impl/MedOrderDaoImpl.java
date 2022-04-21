package com.ty.wellness_care.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.wellness_care.dao.MedOrderDao;
import com.ty.wellness_care.dto.MedOrder;
import com.ty.wellness_care.dto.Prescription;
import com.ty.wellness_care.repository.MedOrderRepository;

@Repository
public class MedOrderDaoImpl implements MedOrderDao {

	@Autowired
	MedOrderRepository medOrderRepository;

	@Override
	public MedOrder saveMedOrder(MedOrder medOrder) {
		return medOrderRepository.save(medOrder);
	}

	@Override
	public MedOrder updateMedOrder(int id, MedOrder medOrder) {
		MedOrder order = getMedOrderById(id);
		if (order != null) {
			medOrder.setMedOrderId(id);
			return medOrderRepository.save(medOrder);

		}
		return null;

	}

	@Override
	public List<MedOrder> getAllMedOrders() {
		return medOrderRepository.findAll();
	}

	@Override
	public MedOrder getMedOrderById(int id) {
		Optional<MedOrder> optional = medOrderRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;

	}

	@Override
	public boolean deleteMedOrder(int id) {

		MedOrder order = getMedOrderById(id);
		if (order != null) {
			medOrderRepository.delete(order);
			return true;
		}
		return false;
	}

}
