package com.ty.wellness_care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.wellness_care.dto.Admin;
import com.ty.wellness_care.dto.User;
import com.ty.wellness_care.service.AdminService;
import com.ty.wellness_care.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class AdminController {

	@Autowired
	AdminService service;

	@PostMapping("admin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return service.saveAdmin(admin);
	}

	@GetMapping("admin/{adminid}")
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(@PathVariable int adminid) {
		return service.getAdminById(adminid);
}

	@GetMapping("admin")
	public ResponseEntity<ResponseStructure<List<Admin>>> getAllAdmins() {
		return service.getAllAdmin();
	}

	@PutMapping("admin/{adminid}")
	public ResponseEntity<ResponseStructure<Admin>> upddateAdmin(@RequestBody Admin admin, @PathVariable int adminid) {
		return service.updateAdmin(admin, adminid);

	}

	@DeleteMapping("admin")
	public ResponseEntity<ResponseStructure<String>> deleteAdmin(@RequestParam int id) {
		return service.deleteAdmin(id);
	}
}
