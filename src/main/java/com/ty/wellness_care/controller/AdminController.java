package com.ty.wellness_care.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.wellness_care.dto.Admin;
import com.ty.wellness_care.service.AdminService;
import com.ty.wellness_care.util.ResponseStructure;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
public class AdminController {

	@Autowired
	AdminService service;

	@PostMapping("admin")
	@ApiResponses({@ApiResponse(code=200,message="Admin saved Successful"),
		@ApiResponse(code=404,message = "Admin Login failed"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@Validated @RequestBody Admin admin) {
		return service.saveAdmin(admin);
	}

	@GetMapping("admin/{adminid}")
	@ApiResponses({@ApiResponse(code=200,message="Retrived Admin "),
		@ApiResponse(code=404,message = "Admin not retrived"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(@PathVariable int adminid) {
		return service.getAdminById(adminid);
	}

	@GetMapping("admin")
	@ApiResponses({@ApiResponse(code=200,message="Retrieved all the admins"),
		@ApiResponse(code=404,message = "Admin not retrieved"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<List<Admin>>> getAllAdmins() {
		return service.getAllAdmin();
	}

	@PutMapping("admin/{adminid}")
	@ApiResponses({@ApiResponse(code=200,message="Admin updated"),
		@ApiResponse(code=404,message = "Admin not updated"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(@RequestBody Admin admin, @PathVariable int adminid) {
		return service.updateAdmin(admin, adminid);

	}

	@DeleteMapping("admin")
		@ApiResponses({@ApiResponse(code=200,message="Admin deleted"),
		@ApiResponse(code=404,message = "Admin not deleted"),
		@ApiResponse(code=500,message = "Internal Server Error")})
	public ResponseEntity<ResponseStructure<String>> deleteAdmin(@RequestParam int id) {
		return service.deleteAdmin(id);
	}
}
