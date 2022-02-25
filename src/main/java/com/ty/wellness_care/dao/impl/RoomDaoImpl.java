package com.ty.wellness_care.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ty.wellness_care.dao.RoomDao;
import com.ty.wellness_care.dto.Room;
import com.ty.wellness_care.repository.RoomRepositry;

public class RoomDaoImpl implements RoomDao{

	@Autowired
    RoomRepositry repositry;
	
	@Override
	public Room saveRoom(Room room) {
		return repositry.save(room);
	}

	@Override
	public Room updateRoom(int id, Room room) {
		if (getRoomById(id) != null) {
			room.setId(id);
			return repositry.save(room);
		}
		return null;
	}

	@Override
	public List<Room> getAllRoom() {
	
		return repositry.findAll();
	}

	@Override
	public Room getRoomById(int id) {
		Optional<Room> optional = repositry.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Room getRoomByFloor(int floorid) {
		Optional<Room> optional = repositry.findById(floorid);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public boolean deleteRoom(int id) {
		Room room = getRoomById(id);
		if (room != null) {
			repositry.delete(room);
			return true;
		}
		return false;
	}


}
