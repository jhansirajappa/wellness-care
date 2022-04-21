package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.wellness_care.dao.FloorDao;
import com.ty.wellness_care.dto.Floor;
import com.ty.wellness_care.exception.IDNotFoundException;
import com.ty.wellness_care.service.FloorService;
import com.ty.wellness_care.util.ResponseStructure;

@Service
public class FloorServiceImpl implements FloorService {

	@Autowired
	FloorDao floorDao;
	
	@Override
	public ResponseEntity<ResponseStructure<Floor>> saveFloor(Floor floor) {
		ResponseStructure<Floor> responseStructure=new ResponseStructure<Floor>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(floorDao.saveFloor(floor));
		ResponseEntity<ResponseStructure<Floor>> responseEntity=new ResponseEntity<ResponseStructure<Floor>>(responseStructure,HttpStatus.OK);
		
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Floor>> updateFloor(int id, Floor floor) {
		Floor floor2=floorDao.updateFloor(id, floor);
		
		if(floor2 != null) {
		ResponseStructure<Floor> responseStructure=new ResponseStructure<Floor>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(floor);
		ResponseEntity<ResponseStructure<Floor>> responseEntity=new ResponseEntity<ResponseStructure<Floor>>(responseStructure,HttpStatus.OK);
		
		return responseEntity;
	}
		else {
		ResponseStructure<Floor> responseStructure=new ResponseStructure<Floor>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("not found");
		responseStructure.setData(null);
		ResponseEntity<ResponseStructure<Floor>> responseEntity=new ResponseEntity<ResponseStructure<Floor>>(responseStructure,HttpStatus.NOT_FOUND);
		
		return responseEntity;
			
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Floor>>> getAllFloor() {
		List<Floor> floors=floorDao.getAllFloor();
		if(floors != null) {
			
		
		ResponseStructure<List<Floor>> responseStructure=new ResponseStructure<List<Floor>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(floors);
		ResponseEntity<ResponseStructure<List<Floor>>> responseEntity=new ResponseEntity<ResponseStructure<List<Floor>>>(responseStructure,HttpStatus.OK);
		
		return responseEntity;
		}
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<Floor>> getFloorById(int id) {
		Floor floor=floorDao.getFloorById(id);
		if(floor != null) {
			
		
		ResponseStructure<Floor> responseStructure=new ResponseStructure<Floor>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(floorDao.getFloorById(id));
		ResponseEntity<ResponseStructure<Floor>> responseEntity=new ResponseEntity<ResponseStructure<Floor>>(responseStructure,HttpStatus.OK);
		
		return responseEntity;
	}
		throw new IDNotFoundException(" Floor id"+id+"not found");
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Floor>>> getFloorByBranch(int branchid) {
		List<Floor> floors=floorDao.getFloorByBranch(branchid);
		if(floors != null) {
			
		
		ResponseStructure<List<Floor>> responseStructure=new ResponseStructure<List<Floor>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData(floorDao.getFloorByBranch(branchid));
		ResponseEntity<ResponseStructure<List<Floor>>> responseEntity=new ResponseEntity<ResponseStructure<List<Floor>>>(responseStructure,HttpStatus.OK);
		return responseEntity;
	}
		throw new IDNotFoundException(" Floor id"+branchid+"not found");
	}
	

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteFloor(int id) {
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity=null;
		if(floorDao.deleteFloor(id)) {
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("success");
		responseStructure.setData("Floor deleted");
		responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.OK);
		return responseEntity;
	}
		else {
			throw new IDNotFoundException(" Floor id"+id+"not found");
		}

	}

}
