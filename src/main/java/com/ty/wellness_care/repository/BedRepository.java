package com.ty.wellness_care.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.wellness_care.dto.Bed;

public interface BedRepository extends JpaRepository<Bed, Integer>{

	@Query("select e from Bed e where e.room.id=?1")
	List<Bed> getBedByRoom(int roomid);

}
