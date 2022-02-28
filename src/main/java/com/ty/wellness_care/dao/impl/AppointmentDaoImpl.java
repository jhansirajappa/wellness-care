package com.ty.wellness_care.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.wellness_care.dao.AppointmentDao;
import com.ty.wellness_care.dto.Appointment;
import com.ty.wellness_care.repository.AppointmentRepository;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {

	@Autowired
	AppointmentRepository appointmentRepository;

	@Override
	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);

	}

	@Override
	public Appointment updateAppointment(int id, Appointment appointment) {

		Appointment existingAppointment = getAppointmentById(id);
		if (existingAppointment != null) {
			appointment.setId(existingAppointment.getId());
			appointmentRepository.save(appointment);
			return appointment;
		}
		return null;
	}

	@Override
	public List<Appointment> getAllAppointment() {
		return appointmentRepository.findAll();
	}

	@Override
	public List<Appointment> getAppointmentByBranch(int id) {
		return appointmentRepository.getAppointmentByBranch(id);
	}

	@Override
	public List<Appointment> getAppointmentByDoctor(int id) {
		return appointmentRepository.getAppointmentByDoctor(id);
	}

	@Override
	public List<Appointment> getAppointmentByUser(int id) {
		return appointmentRepository.getAppointmentByUser(id);
	}

	@Override
	public boolean deleteAppointment(int id) {
		Appointment appointment = getAppointmentById(id);
		if (appointment != null) {
			appointmentRepository.delete(appointment);
			return true;
		}
		return false;
	}

	@Override
	public Appointment getAppointmentById(int appointmentId) {
		Optional<Appointment> optional = appointmentRepository.findById(appointmentId);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
