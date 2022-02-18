package com.ty.wellness_care.dao;

import java.util.List;

import com.ty.wellness_care.dto.Floor;

public interface FloorDao {

	public Floor saveFloor(Floor floor);
	public Floor updateFloor(int id,Floor floor);
	public List<Floor> getAllFloor();
	public List<Floor> getFloorById( int id);
	public List<Floor> getFloorByBranch(int branchid);
	public String deleteFloor(int id);

}
