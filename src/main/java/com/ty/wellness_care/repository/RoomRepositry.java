package com.ty.wellness_care.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.wellness_care.dto.Room;

public interface RoomRepositry extends JpaRepository<Room, Integer>{

	@Query("select r from Room r where r.floor.id=?1")
	List<Room> getRoomByFloor(int floorid);

}
