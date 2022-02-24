package com.ty.wellness_care.dao;

import java.util.List;

import com.ty.wellness_care.dto.Appointment;

public interface AppointmentDao {


	public Appointment saveAppointment(Appointment appointment);
	public Appointment updateAppointment(int id,Appointment appointment);
	public List<Appointment> getAllAppointment();
	public List<Appointment> getAppointmentByBranch( int id);
	public List<Appointment> getAppointmentByDoctor( int id);
	public List<Appointment> getAppointmentByUser( int id);
	public Appointment getAppointmentById(int appointmentId );
	public boolean deleteAppointment(int id);
	
	
}
