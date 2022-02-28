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

import com.ty.wellness_care.controller.BedController;
import com.ty.wellness_care.dao.BedDao;
import com.ty.wellness_care.dto.Bed;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BedControllerTest {

	@Autowired
	private BedController controller;

	@MockBean  
	private BedDao dao;

	@Test
	public void saveBedTest() {

		Bed bed = new Bed();
		when(dao.saveBed(bed)).thenReturn(bed);
		assertEquals(bed, controller.saveBed(bed).getBody().getData());
	}

	@Test
	public void getBedByIdTest() {

		Bed bed = new Bed();
		when(dao.getBedById(1)).thenReturn(bed);
		assertEquals(bed, controller.getBedById(1).getBody().getData());

	}

	@Test
	public void getAllBedTest() {
		List<Bed> beds = new ArrayList<Bed>();
		Bed bed1 = new Bed();
		Bed bed2 = new Bed();
		Bed bed3 = new Bed();
		beds.add(bed1);
		beds.add(bed2);
		beds.add(bed3);

		when(dao.getAllBed()).thenReturn(beds);
		assertEquals(3, controller.getAllBed().getBody().getData().size());
	}

	@Test
	public void updateBedTest() {

		Bed  bed = new Bed();
		when(dao.updateBed(1, bed)).thenReturn(bed);
		assertEquals(bed, controller.updateBed(1, bed).getBody().getData());
	}
	

	@Test
	public void getBedByRoomTest() {

		List<Bed> beds = new ArrayList<Bed>();
		Bed bed1 = new Bed();
		Bed bed2 = new Bed();
		Bed bed3 = new Bed();
		beds.add(bed1);
		beds.add(bed2);
		beds.add(bed3);
		when(dao.getBedByRoom(1)).thenReturn(beds);
		assertEquals(beds, controller.getBedByRoom(1).getBody().getData());

	}

	@Test
	public void deleteBedTest() {

		boolean b = true;
		String del="Bed deleted";
		when(dao.deleteBed(1)).thenReturn(b);
		assertEquals(del, controller.deleteBed(1).getBody().getData());

	}
}
