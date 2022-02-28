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

import com.ty.wellness_care.controller.FloorController;
import com.ty.wellness_care.dao.FloorDao;
import com.ty.wellness_care.dto.Floor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FloorControllerTest {

	@Autowired
	private FloorController controller;

	@MockBean  
	private FloorDao dao;

	@Test
	public void saveFloorTest() {

		Floor floor = new Floor();
		when(dao.saveFloor(floor)).thenReturn(floor);
		assertEquals(floor, controller.saveFloor(floor).getBody().getData());
	}

	@Test
	public void getFloorByIdTest() {

		Floor floor = new Floor();
		when(dao.getFloorById(1)).thenReturn(floor);
		assertEquals(floor, controller.getFloorById(1).getBody().getData());

	}

	@Test
	public void getAllFloorTest() {
		List<Floor> floors = new ArrayList<Floor>();
		Floor floor1 = new Floor();
		Floor floor2 = new Floor();
		Floor floor3 = new Floor();
		floors.add(floor1);
		floors.add(floor2);
		floors.add(floor3);

		when(dao.getAllFloor()).thenReturn(floors);
		assertEquals(3, controller.getAllFloor().getBody().getData().size());
	}

	@Test
	public void updateFloorTest() {

		Floor  floor = new Floor();
		when(dao.updateFloor(1, floor)).thenReturn(floor);
		assertEquals(floor, controller.updateFloor(floor, 1).getBody().getData());
	}
	

	@Test
	public void getFloorByBranchTest() {

		List<Floor> floors = new ArrayList<Floor>();
		Floor floor1 = new Floor();
		Floor floor2 = new Floor();
		Floor floor3 = new Floor();
		floors.add(floor1);
		floors.add(floor2);
		floors.add(floor3);
		when(dao.getFloorByBranch(1)).thenReturn(floors);
		assertEquals(floors, controller.getFloorByBranch(1).getBody().getData());

	}

	@Test
	public void deleteFloorTest() {

		boolean b = true;
		String del="Floor deleted";
		when(dao.deleteFloor(1)).thenReturn(b);
		assertEquals(del, controller.deleteFloor(1).getBody().getData());

	}
}
