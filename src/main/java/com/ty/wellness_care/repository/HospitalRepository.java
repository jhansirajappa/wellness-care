package com.ty.wellness_care.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.wellness_care.dto.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

}
