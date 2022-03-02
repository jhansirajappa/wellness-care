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

import com.ty.wellness_care.controller.RoomController;
import com.ty.wellness_care.dao.RoomDao;
import com.ty.wellness_care.dto.Room;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomControllerTest {

	@MockBean
	private RoomController controller;
	@Autowired
	private RoomDao dao;

	@Test
	public void saveRoomTest() {

		Room room = new Room();
		when(dao.saveRoom(room)).thenReturn(room);
		assertEquals(room, controller.saveRoom(room).getBody().getData());

	}
	@Test
	public void updateRoomTest() {
		Room room = new Room();
		when(dao.updateRoom(1,room)).thenReturn(room);
		assertEquals(room, controller.updateRoom(1, room).getBody().getData());
	}
	@Test
	public void getAllRooms() {
		List<Room> rooms = new ArrayList<Room>();
		Room room1 = new Room();
		Room room2 = new Room();
		Room room3 = new Room();
		
		rooms.add(room1);
		rooms.add(room2);
		rooms.add(room3);
		
		when(dao.getAllRoom()).thenReturn(rooms);
		assertEquals(3, controller.getAllRoom().getBody().getData().size());
	}
	@Test
	public void getRoomByIdTest() {
		Room room = new Room();
		when(dao.getRoomById(1)).thenReturn(room);
		assertEquals(room, controller.getRoomById(1).getBody().getData());	
	}
	
	@Test
	public void deleteRoomTest() {

		boolean b = true;
		String del = "Room Deleted";
		when(dao.deleteRoom(1)).thenReturn(b);
		assertEquals(del, controller.deleteRoom(1).getBody().getData());

	}
}