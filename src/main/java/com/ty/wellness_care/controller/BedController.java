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

import com.ty.wellness_care.dto.Bed;
import com.ty.wellness_care.repository.BedRepository;
import com.ty.wellness_care.service.BedService;
import com.ty.wellness_care.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BedController {

	@Autowired
	BedService bedService;

	@PostMapping("room/bed")
	@ApiOperation("To Save Bed")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Bed>> saveBed(@RequestBody Bed bed) {
		return bedService.saveBed(bed);
	}

	@PutMapping("room/bed/{bedid}")
	@ApiOperation("To Update Bed By Id")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Bed>> updateBed(@PathVariable int bedid,@RequestBody Bed bed) {
		return bedService.updateBed(bedid, bed);
	}

	@GetMapping("room/bed")
	@ApiOperation("To Get All Beds")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Bed>>> getAllBed() {
		return bedService.getAllBed();
	}

	@GetMapping("room/bed/{bedid}")
	@ApiOperation("To Get Bed By Id")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Bed>> getBedById(@PathVariable int bedid) {
		return bedService.getBedById(bedid);
	}

	@GetMapping("room/{roomid}/bed")
	@ApiOperation("To Get Bed By Room Id")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Bed>>> getBedByRoom(@PathVariable int roomid) {
		return bedService.getBedByRoom(roomid);
	}

	@DeleteMapping("room/bed")
	@ApiOperation("To Delete Bed By Id")
	@ApiResponses({@ApiResponse(code=200,message="Retrived User"),@ApiResponse(code=404,message = "ID not found"),@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<String>> deleteBed(@RequestParam int id) {
		return bedService.deleteBed(id);
	}

}
