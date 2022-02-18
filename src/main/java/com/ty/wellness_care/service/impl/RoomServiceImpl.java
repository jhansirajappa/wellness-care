package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.Room;
import com.ty.wellness_care.service.RoomService;
import com.ty.wellness_care.util.ResponseStructure;

public class RoomServiceImpl implements RoomService{

	@Override
	public ResponseEntity<ResponseStructure<Room>> saveRoom(Room room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Room>> updateRoom(int id, Room room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Room>>> getAllRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Room>>> getRoomById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Room>>> getRoomByFloor(int floorid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteRoom(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
