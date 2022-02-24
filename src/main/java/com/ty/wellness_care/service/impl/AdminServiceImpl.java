package com.ty.wellness_care.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ty.wellness_care.dao.AdminDao;
import com.ty.wellness_care.dto.Admin;
import com.ty.wellness_care.service.AdminService;
import com.ty.wellness_care.util.ResponseStructure;

public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;

	@Override
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("successful");
		structure.setData(adminDao.saveAdmin(admin));
		ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
				structure, HttpStatus.OK);
		return responseEntity;
	}

	@Override
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int adminId) {
		Admin admin = adminDao.getAdminById(adminId);
		if (admin != null) {
			ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("successfull");
			structure.setData(admin);
			ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
					structure, HttpStatus.OK);

			return responseEntity;
		} else {
			return null;
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Admin>>> getAllAdmin() {
		List<Admin> admins = adminDao.getAllAdmins();
		ResponseStructure<List<Admin>> structure = new ResponseStructure<List<Admin>>();

		if (admins != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("successful");
			structure.setData(admins);
			ResponseEntity<ResponseStructure<List<Admin>>> reponseEntity = new ResponseEntity<ResponseStructure<List<Admin>>>(
					structure, HttpStatus.OK);

			return reponseEntity;
		} else {
			return null;
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin, int adminId) {
		Admin adminid = adminDao.getAdminById(adminId);
		if (adminid != null) {
			ResponseStructure<Admin> structure = new ResponseStructure<Admin>();
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("successful");
			structure.setData(adminDao.updateAdmin(adminId, admin));
			ResponseEntity<ResponseStructure<Admin>> responseEntity = new ResponseEntity<ResponseStructure<Admin>>(
					structure, HttpStatus.OK);

			return responseEntity;

		} else {
			return null;
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<String>> deleteAdmin(int adminId) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity;

		if (adminDao.deleteAdmin(adminId)) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("successful");
			structure.setData("Admin deleted");
			responseEntity = new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
			return responseEntity;
		} else {
			return null;
		}
	}

}
