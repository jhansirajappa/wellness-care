package com.ty.wellness_care.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.wellness_care.dto.Floor;

public interface FloorRepositry extends JpaRepository<Floor, Integer>{

	@Query("select f from Floor f where f.branch.id=?1")
	List<Floor> getFloorByBranch(int branchid);

}
