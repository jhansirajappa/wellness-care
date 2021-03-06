package com.ty.wellness_care.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel(value = "Appointment Entity", description = "Appointment Entity to hold User Details")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime dateTime;
	@NotNull(message = "Patient Name cannot be null")
	private String patientName;
	private long mobileNo;
	private String address;
	private String state;
	private String country;
	@Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}", message = "Enter Proper Mail ID")
	private String email;
	private int age;
	private String gender;
	private String reason;

	@ManyToOne
	@JoinColumn
	private User user;

	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Branch branch;

	@ManyToOne
	@JoinColumn
	@JsonIgnore
	private Doctor doctor;
	
	
	

	public Appointment() {
		super();
	}

	public Appointment(int id, LocalDateTime dateTime, String patientName, long mobileNo, String address, String state,
			String country, String email, int age, String gender, String reason, User user, Branch branch,
			Doctor doctor) {
		super();
		this.id = id;
		this.dateTime = dateTime;
		this.patientName = patientName;
		this.mobileNo = mobileNo;
		this.address = address;
		this.state = state;
		this.country = country;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.reason = reason;
		this.user = user;
		this.branch = branch;
		this.doctor = doctor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
