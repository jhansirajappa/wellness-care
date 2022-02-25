package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.wellness_care.dao.BedDao;
import com.ty.wellness_care.dto.Bed;
import com.ty.wellness_care.dto.Branch;
import com.ty.wellness_care.exception.HospitalNotFoundException;
import com.ty.wellness_care.exception.IDNotFoundException;
import com.ty.wellness_care.service.BedService;
import com.ty.wellness_care.util.ResponseStructure;

@Service
public class BedServiceImpl implements BedService{

	@Autowired
	BedDao bedDao;

	@Override
	public ResponseEntity<ResponseStructure<Bed>> saveBed(Bed bed) {
		ResponseStructure<Bed> responseStructure=new ResponseStructure<Bed>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(bedDao.saveBed(bed));
		ResponseEntity<ResponseStructure<Bed>> responseEntity=new ResponseEntity<ResponseStructure<Bed>>(responseStructure,HttpStatus.OK);

		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Bed>> updateBed(int id, Bed bed) {
		Bed bed2= bedDao.getBedById(id);

		if(bed2 != null) {
			bed.setId(bed2.getId());
			bedDao.updateBed(id, bed2);
			ResponseStructure<Bed> responseStructure=new ResponseStructure<Bed>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("success");
			responseStructure.setData(bed);
			ResponseEntity<ResponseStructure<Bed>> responseEntity=new ResponseEntity<ResponseStructure<Bed>>(responseStructure,HttpStatus.OK);
			return responseEntity;
		}
		else {
			ResponseStructure<Bed> responseStructure=new ResponseStructure<Bed>();
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("not found");
			responseStructure.setData(null);
			ResponseEntity<ResponseStructure<Bed>> responseEntity=new ResponseEntity<ResponseStructure<Bed>>(responseStructure,HttpStatus.NOT_FOUND);

			return responseEntity;

		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Bed>>> getAllBed() {
		List<Bed> beds=bedDao.getAllBed();
		if(beds != null) {
			
		
		ResponseStructure<List<Bed>> responseStructure=new ResponseStructure<List<Bed>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(beds);
		ResponseEntity<ResponseStructure<List<Bed>>> responseEntity=new ResponseEntity<ResponseStructure<List<Bed>>>(responseStructure,HttpStatus.OK);
		
		return responseEntity;
		}
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Bed>> getBedById(int id) {
		Bed bed=bedDao.getBedById(id);
		if(bed != null) {
			
		
		ResponseStructure<Bed> responseStructure=new ResponseStructure<Bed>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(bedDao.getBedById(id));
		ResponseEntity<ResponseStructure<Bed>> responseEntity=new ResponseEntity<ResponseStructure<Bed>>(responseStructure,HttpStatus.OK);
		
		return responseEntity;
	}
		throw new IDNotFoundException(" Bed id"+id+"not found");
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Bed>>> getBedByRoom(int roomid) {
		List<Bed> beds=bedDao.getBedByRoom(roomid);
		if(beds != null) {
			
		
		ResponseStructure<List<Bed>> responseStructure=new ResponseStructure<List<Bed>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(bedDao.getBedByRoom(roomid));
		ResponseEntity<ResponseStructure<List<Bed>>> responseEntity=new ResponseEntity<ResponseStructure<List<Bed>>>(responseStructure,HttpStatus.OK);
		return responseEntity;
	}
		throw new IDNotFoundException(" Bed id"+roomid+"not found");

	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteBed(int id) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity=null;
		if(bedDao.deleteBed(id)) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData("Branch deleted");
		responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
		return responseEntity;
	}
		else {
			throw new IDNotFoundException(" Bed id"+id+"not found");
		}
	}

}
