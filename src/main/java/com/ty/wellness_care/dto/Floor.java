package com.ty.wellness_care.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Floor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int floor_no;
	
	@OneToMany(mappedBy = "floor")
	@JsonIgnore
	List<Room> room;
	
	@ManyToOne
	@JoinColumn
	Branch branch;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFloor_no() {
		return floor_no;
	}

	public void setFloor_no(int floor_no) {
		this.floor_no = floor_no;
	}

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	
}
