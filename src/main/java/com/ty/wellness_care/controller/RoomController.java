package com.ty.wellness_care.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.wellness_care.dto.Room;
import com.ty.wellness_care.util.ResponseStructure;

@RestController
public class RoomController {

	@PostMapping("floor/room")
	public ResponseEntity<ResponseStructure<Room>> saveRoom(@RequestBody Room room) {
		// TODO Auto-generated method stub
		return null;
	}

	@PutMapping("floor/room/{roomid}")
	public ResponseEntity<ResponseStructure<Room>> updateRoom(@PathVariable int roomid,@RequestBody Room room) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("floor/room")
	public ResponseEntity<ResponseStructure<List<Room>>> getAllRoom() {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("floor/room/{roomid}")
	public ResponseEntity<ResponseStructure<List<Room>>> getRoomById(@PathVariable int Roomid) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("floor/{floorid}/room")
	public ResponseEntity<ResponseStructure<List<Room>>> getRoomByFloor(@PathVariable int floorid) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("floor/room")
	public String deleteRoom(@RequestParam int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
