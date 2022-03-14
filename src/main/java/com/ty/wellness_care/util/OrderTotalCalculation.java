
package com.ty.wellness_care.util;

import java.util.List;

import com.ty.wellness_care.dto.Lab;
import com.ty.wellness_care.dto.MedOrder;
import com.ty.wellness_care.dto.Prescription;

public class OrderTotalCalculation {

	public double getOrderCalculation(Prescription prescription) {
		double total = 0;
		List<MedOrder> medOrders = prescription.getMedOrders();

		for (MedOrder order : medOrders) {
			total += order.getCost();
		}

		List<Lab> labs = prescription.getLabs();
		for (Lab lab : labs) {
			total += lab.getFees();
		}

		return total;
	}
}
