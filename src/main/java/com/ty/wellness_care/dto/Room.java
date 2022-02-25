package com.ty.wellness_care.dto;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Room {

	private int id;
	private int room_no;
	
	@OneToMany
	List<Bed> bed;
	
	@ManyToOne
	@JoinColumn
	Floor floor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public List<Bed> getBed() {
		return bed;
	}

	public void setBed(List<Bed> bed) {
		this.bed = bed;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	
	
}
