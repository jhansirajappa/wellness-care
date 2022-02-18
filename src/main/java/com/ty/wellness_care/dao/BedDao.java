package com.ty.wellness_care.dao;

import java.util.List;

import com.ty.wellness_care.dto.Bed;

public interface BedDao {

	public Bed saveBed(Bed bed);
	public Bed updateBed(int id,Bed bed);
	public List<Bed> getAllBed();
	public List<Bed> getBedById( int id);
	public List<Bed> getBedByRoom(int roomid);
	public String deleteBed(int id);

}
