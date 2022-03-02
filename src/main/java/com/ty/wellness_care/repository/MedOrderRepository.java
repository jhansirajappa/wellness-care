package com.ty.wellness_care.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.wellness_care.dto.MedOrder;

public interface MedOrderRepository extends JpaRepository<MedOrder, Integer> {

	
	@Query("SELECT m FROM MedOrder m WHERE m.prescription.id=?1")
	public List<MedOrder> getMedOrderByPrescription(int id);
	
}
