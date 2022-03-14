package com.ty.wellness_care.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.wellness_care.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.email=?1 and u.password=?2")
	public User validateUser(String email, String password);

}
