package com.ty.wellness_care.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.wellness_care.dao.AdminDao;
import com.ty.wellness_care.dto.Admin;
import com.ty.wellness_care.repository.AdminRepository;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	AdminRepository adminRepository;

	@Override
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}

	@Override
	public Admin updateAdmin(int id, Admin admin) {
		Admin existingAdmin = getAdminById(id);
		if (existingAdmin != null) {
			existingAdmin.setAdminId(admin.getAdminId());
			existingAdmin.setEmail(admin.getEmail());
			existingAdmin.setPassword(admin.getPassword());
			existingAdmin.setName(admin.getName());

			return existingAdmin;
		}
		return null;
	}

	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}

	@Override
	public boolean deleteAdmin(int id) {
		Admin admin = getAdminById(id);
		if (admin != null) {
			adminRepository.delete(admin);
			return true;
		}
		return false;
	}

	@Override
	public Admin getAdminById(int id) {
		Optional<Admin> optional = adminRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
