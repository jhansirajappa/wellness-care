package com.ty.wellness_care.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.wellness_care.dao.FloorDao;
import com.ty.wellness_care.dto.Floor;
import com.ty.wellness_care.repository.FloorRepositry;

@Repository
public class FloorDaoImpl implements FloorDao{

	@Autowired
	FloorRepositry repositry;
	
	@Override
	public Floor saveFloor(Floor floor) {
		return repositry.save(floor);
	}

	@Override
	public Floor updateFloor(int id, Floor floor) {
		if (getFloorById(id) != null) {
			floor.setId(id);
			return repositry.save(floor);
		}
		return null;
	}

	@Override
	public List<Floor> getAllFloor() {
	
		return repositry.findAll();
	}

	@Override
	public Floor getFloorById(int id) {
		Optional<Floor> optional = repositry.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Floor> getFloorByBranch(int branchid) {
	return repositry.getFloorByBranch(branchid);
	}

	@Override
	public boolean deleteFloor(int id) {
		Floor floor = getFloorById(id);
		if (floor != null) {
			repositry.delete(floor);
			return true;
		}
		return false;
	}

}
