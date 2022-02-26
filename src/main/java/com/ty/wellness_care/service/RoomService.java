package com.ty.wellness_care.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.Room;
import com.ty.wellness_care.util.ResponseStructure;

public interface RoomService {


	public ResponseEntity<ResponseStructure<Room>>  saveRoom(Room room);
	public ResponseEntity<ResponseStructure<Room>>  updateRoom(int id,Room room);
	public ResponseEntity<ResponseStructure<List<Room>>> getAllRoom();
	public ResponseEntity<ResponseStructure<Room>> getRoomById( int id);
	public ResponseEntity<ResponseStructure<List<Room>>> getRoomByFloor(int floorid);
	public ResponseEntity<ResponseStructure<String>> deleteRoom(int id);

}
