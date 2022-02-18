package com.ty.wellness_care.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.Bed;
import com.ty.wellness_care.util.ResponseStructure;

public interface BedService {


	public ResponseEntity<ResponseStructure<Bed>>  saveBed(Bed bed);
	public ResponseEntity<ResponseStructure<Bed>>  updateBed(int id,Bed bed);
	public ResponseEntity<ResponseStructure<List<Bed>>> getAllBed();
	public ResponseEntity<ResponseStructure<List<Bed>>> getBedById( int id);
	public ResponseEntity<ResponseStructure<List<Bed>>> getBedByRoom(int roomid);
	public ResponseEntity<ResponseStructure<String>> deleteBed(int id);

}
