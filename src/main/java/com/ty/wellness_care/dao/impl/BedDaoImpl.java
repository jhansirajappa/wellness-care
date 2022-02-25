package com.ty.wellness_care.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.wellness_care.dao.BedDao;
import com.ty.wellness_care.dto.Bed;
import com.ty.wellness_care.repository.BedRepository;

@Repository
public class BedDaoImpl implements BedDao{
	@Autowired
	BedRepository repositry;
	
	@Override
	public Bed saveBed(Bed bed) {
		return repositry.save(bed);
	}

	@Override
	public Bed updateBed(int id, Bed bed) {
		if (getBedById(id) != null) {
			bed.setId(id);
			return repositry.save(bed);
		}
		return null;
	}

	@Override
	public List<Bed> getAllBed() {
	
		return repositry.findAll();
	}

	@Override
	public Bed getBedById(int id) {
		Optional<Bed> optional = repositry.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Bed> getBedByRoom(int roomid) {
	return repositry.getBedByRoom(roomid);
	}

	@Override
	public boolean deleteBed(int id) {
		Bed bed = getBedById(id);
		if (bed != null) {
			repositry.delete(bed);
			return true;
		}
		return false;
	}

}
