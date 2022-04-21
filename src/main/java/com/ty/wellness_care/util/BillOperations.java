
package com.ty.wellness_care.util;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ty.wellness_care.dto.Medication;

@Service
public class BillOperations {

	public double getTotal(List<Medication> medications) {
		double totalCost = 0;
		if (medications != null) {
			for (Medication medication : medications) {
				totalCost += medication.getCost();
			}
		}
		return totalCost;

	}
}
