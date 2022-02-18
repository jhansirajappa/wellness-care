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

import com.ty.wellness_care.dto.Bed;
import com.ty.wellness_care.util.ResponseStructure;

@RestController
public class BedController {

	@PostMapping("room/bed")
	public ResponseEntity<ResponseStructure<Bed>> saveBed(@RequestBody Bed bed) {
		// TODO Auto-generated method stub
		return null;
	}

	@PutMapping("room/bed/{bedid}")
	public ResponseEntity<ResponseStructure<Bed>> updateBed(@PathVariable int bedid,@RequestBody Bed bed) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("room/bed")
	public ResponseEntity<ResponseStructure<List<Bed>>> getAllBed() {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("room/bed/{bedid}")
	public ResponseEntity<ResponseStructure<List<Bed>>> getBedById(@PathVariable int bedid) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("room/{roomid}/bed")
	public ResponseEntity<ResponseStructure<List<Bed>>> getBedByRoom(@PathVariable int roomid) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("room/bed")
	public String deleteBed(@RequestParam int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
