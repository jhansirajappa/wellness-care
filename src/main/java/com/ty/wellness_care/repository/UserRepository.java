package com.ty.wellness_care.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.wellness_care.dto.User;


public interface UserRepository extends JpaRepository<User,Integer>{
	

}
