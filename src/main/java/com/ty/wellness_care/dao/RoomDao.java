package com.ty.wellness_care.dao;

import java.util.List;

import com.ty.wellness_care.dto.Room;

public interface RoomDao {

	public Room saveRoom(Room room);
	public Room updateRoom(int id,Room room);
	public List<Room> getAllRoom();
	public List<Room> getRoomById( int id);
	public List<Room> getRoomByFloor(int floorid);
	public String deleteRoom(int id);

}
