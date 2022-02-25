package com.ty.wellness_care.dao;

import java.util.List;

import com.ty.wellness_care.dto.Admin;

public interface AdminDao {

	Admin saveAdmin(Admin admin);

	Admin updateAdmin(int id, Admin admin);

	List<Admin> getAllAdmins();

	boolean deleteAdmin(int id);

	Admin getAdminById(int id);
}
