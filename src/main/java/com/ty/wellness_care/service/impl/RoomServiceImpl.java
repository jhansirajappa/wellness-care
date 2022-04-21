package com.ty.wellness_care.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.wellness_care.dao.RoomDao;
import com.ty.wellness_care.dto.Hospital;
import com.ty.wellness_care.dto.Room;
import com.ty.wellness_care.exception.IDNotFoundException;
import com.ty.wellness_care.service.RoomService;
import com.ty.wellness_care.util.ResponseStructure;

@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	RoomDao roomDao;
	
	@Override
	public ResponseEntity<ResponseStructure<Room>> saveRoom(Room room) {
		ResponseStructure<Room> responseStructure=new ResponseStructure<Room>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(roomDao.saveRoom(room));
		ResponseEntity<ResponseStructure<Room>> responseEntity=new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.OK);
		
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Room>> updateRoom(int id, Room room) {
		//Room room2=roomDao.getRoomById(id);
		
		if(room != null) {
			room.setId(room.getId());
			roomDao.updateRoom(id, room);
		ResponseStructure<Room> responseStructure=new ResponseStructure<Room>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(room);
		ResponseEntity<ResponseStructure<Room>> responseEntity=new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.OK);
		
		return responseEntity;
	}
		else {
		ResponseStructure<Room> responseStructure=new ResponseStructure<Room>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("not found");
		responseStructure.setData(null);
		ResponseEntity<ResponseStructure<Room>> responseEntity=new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.NOT_FOUND);
		
		return responseEntity;
			
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Room>>> getAllRoom() {
		List<Room> rooms=roomDao.getAllRoom();
		if(rooms != null) {
			
		
		ResponseStructure<List<Room>> responseStructure=new ResponseStructure<List<Room>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(rooms);
		ResponseEntity<ResponseStructure<List<Room>>> responseEntity=new ResponseEntity<ResponseStructure<List<Room>>>(responseStructure,HttpStatus.OK);
		
		return responseEntity;
		}
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Room>> getRoomById(int id) {
		
		Room room=roomDao.getRoomById(id);
		if(room != null) {
			
		
		ResponseStructure<Room> responseStructure=new ResponseStructure<Room>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(roomDao.getRoomById(id));
		ResponseEntity<ResponseStructure<Room>> responseEntity=new ResponseEntity<ResponseStructure<Room>>(responseStructure,HttpStatus.OK);
		
		return responseEntity;
	}
		throw new IDNotFoundException(" Room id"+id+"not found");
	}

	@Override
	public ResponseEntity<ResponseStructure<Room>> getRoomByFloor(int floorid) {
		List<Room> rooms=roomDao.getRoomByFloor(floorid);
		if(rooms != null) {
			
		
		ResponseStructure<List<Room>> responseStructure=new ResponseStructure<List<Room>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(roomDao.getRoomByFloor(floorid));
		ResponseEntity<ResponseStructure<Room>> responseEntity=new ResponseEntity<ResponseStructure<Room>>(HttpStatus.OK);
		return responseEntity;
	}
		throw new IDNotFoundException(" Hospital id"+floorid+"not found");
	}
	

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteRoom(int id) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity=null;
		if(roomDao.deleteRoom(id)) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData("Room deleted");
		responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
		return responseEntity;
	}
		else {
			throw new IDNotFoundException(" Floor id"+id+"not found");
		}
	}

}
