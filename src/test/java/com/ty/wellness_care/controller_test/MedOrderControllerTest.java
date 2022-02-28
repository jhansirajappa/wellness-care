package com.ty.wellness_care.controller_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ty.wellness_care.controller.MedOrderController;
import com.ty.wellness_care.dao.MedOrderDao;
import com.ty.wellness_care.dto.MedOrder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedOrderControllerTest {

	@Autowired
	MedOrderController controller;
	
	@MockBean
	MedOrderDao dao;
	
	@Test
	public void saveMedOrderTest() {

	MedOrder medOrder = new MedOrder();
		when(dao.saveMedOrder(medOrder)).thenReturn(medOrder);
		assertEquals(medOrder, controller.saveMedOrder(medOrder).getBody().getData());
	}

	@Test
	public void getMedOrderByIdTest() {
		MedOrder medOrder = new MedOrder();
		when(dao.getMedOrderById(1)).thenReturn(medOrder);
		assertEquals(medOrder, controller.getMedOrderById(1).getBody().getData());

	}

	@Test
	public void getAllMedOrderTest() {
		List<MedOrder> medOrders = new ArrayList<MedOrder>();

		MedOrder medOrder1=new MedOrder();
		MedOrder medOrder2=new MedOrder();
		MedOrder medOrder3=new MedOrder();
		medOrders.add(medOrder3);
		medOrders.add(medOrder2);
		medOrders.add(medOrder1);

		when(dao.getAllMedOrders()).thenReturn(medOrders);
		assertEquals(3, controller.getAllMedOrders().getBody().getData().size());
	}

	@Test
	public void updateMedOrderTest() {

		MedOrder medorder= new MedOrder();
		when(dao.updateMedOrder(1, medorder)).thenReturn(medorder);
		assertEquals(medorder, controller.updateMedOrder(1, medorder).getBody().getData());
	}

	@Test
	public void deleteMedorderTest() {

		boolean b = true;
		String del = "MedOrder Deleted";
		when(dao.deleteMedOrder(1)).thenReturn(b);
		assertEquals(del, controller.deleteMedOrder(1).getBody().getData());

	}

	
}
