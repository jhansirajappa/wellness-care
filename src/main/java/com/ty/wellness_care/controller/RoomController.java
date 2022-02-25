package com.ty.wellness_care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.ty.wellness_care.service.RoomService;
import com.ty.wellness_care.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class RoomController {

	@Autowired
	RoomService roomService;
	
	@PostMapping("floor/room")
	@ApiOperation("To Save Room")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Room>> saveRoom(@RequestBody Room room) {
		return roomService.saveRoom(room);
	}

	@PutMapping("floor/room/{roomid}")
	@ApiOperation("To Update Room")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Room>> updateRoom(@PathVariable int roomid,@RequestBody Room room) {
		return roomService.updateRoom(roomid, room);
	}

	@GetMapping("floor/room")
	@ApiOperation("To Get All Rooms")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Room>>> getAllRoom() {
		return roomService.getAllRoom();
	}

	@GetMapping("floor/room/{roomid}")
	@ApiOperation("To Room By Id")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Room>> getRoomById(@PathVariable int Roomid) {
		return roomService.getRoomById(Roomid);
	}

	@GetMapping("floor/{floorid}/room")
	@ApiOperation("To Get Room By Floor Id")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Room>>> getRoomByFloor(@PathVariable int floorid) {
		return roomService.getRoomByFloor(floorid);
	}

	@DeleteMapping("floor/room")
	@ApiOperation("To Delete Room")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<String>> deleteRoom(@RequestParam int id) {
		return roomService.deleteRoom(id);
	}

}
