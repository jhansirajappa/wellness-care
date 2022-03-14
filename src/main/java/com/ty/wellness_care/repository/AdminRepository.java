package com.ty.wellness_care.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.wellness_care.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	

	@Query("Select a from Admin a where a.email=?1 and a.password=?2")
	public Admin validateAdmin(String email, String password);

}
