package com.ty.wellness_care.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel(value = "Admin Entity", description = "Admin Entity to hold User Details")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	@Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Enter Proper Mail ID")
	private String email;
	@Size(min = 8)
	private String password;
	@NotNull(message = "Name cannot be null")
	private String name;

	@ManyToOne
	@JoinColumn
	private Hospital hospital;

	public Admin(int adminId, String email, String password, String name, Hospital hospital) {
		super();
		this.adminId = adminId;
		this.email = email;
		this.password = password;
		this.name = name;
		this.hospital = hospital;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Admin() {
		super();
	}

}
