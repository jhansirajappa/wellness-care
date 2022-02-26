package com.ty.wellness_care.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dto.Admin;
import com.ty.wellness_care.util.ResponseStructure;

public interface AdminService {
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin);

	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int adminId);

	public ResponseEntity<ResponseStructure<List<Admin>>> getAllAdmin();

	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin, int adminId);

	public ResponseEntity<ResponseStructure<String>> deleteAdmin(int adminId);


}
