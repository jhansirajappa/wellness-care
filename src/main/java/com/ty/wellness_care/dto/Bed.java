package com.ty.wellness_care.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bed {

	@Id
	private int id;
	private int bed_no;
	
	@ManyToOne
	@JoinColumn
	 Room room;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBed_no() {
		return bed_no;
	}

	public void setBed_no(int bed_no) {
		this.bed_no = bed_no;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	
}
