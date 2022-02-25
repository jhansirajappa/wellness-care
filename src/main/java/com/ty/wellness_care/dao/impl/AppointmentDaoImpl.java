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
			existingAppointment.setAddress(appointment.getAddress());
			existingAppointment.setAge(appointment.getAge());
			existingAppointment.setBranch(appointment.getBranch());
			existingAppointment.setCountry(appointment.getCountry());
			existingAppointment.setDateTime(appointment.getDateTime());
			existingAppointment.setDoctor(appointment.getDoctor());
			existingAppointment.setEmail(appointment.getEmail());
			existingAppointment.setGender(appointment.getGender());
			existingAppointment.setMobileNo(appointment.getMobileNo());
			existingAppointment.setPatientName(appointment.getPatientName());
			existingAppointment.setReason(appointment.getReason());
			existingAppointment.setState(appointment.getState());
			existingAppointment.setUser(appointment.getUser());
			appointmentRepository.save(existingAppointment);
			return existingAppointment;
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
