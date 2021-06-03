package com.g6.onlineeyecare.doctor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.g6.onlineeyecare.appointment.dto.Appointment;
import com.g6.onlineeyecare.appointment.service.IAppointmentService;
import com.g6.onlineeyecare.doctor.dao.IDoctorRepository;
import com.g6.onlineeyecare.doctor.dto.Doctor;
import com.g6.onlineeyecare.exceptions.DoctorIdNotFoundException;
import com.g6.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.g6.onlineeyecare.test.dto.Test;
import com.g6.onlineeyecare.test.service.ITestService;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	IDoctorRepository repository;
	@Autowired
	IAppointmentService appointmentService;
	@Autowired
	ITestService testService;

	public DoctorServiceImpl(IDoctorRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	@Transactional
	public Doctor addDoctor(Doctor doctor) {
		try {
			repository.save(doctor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctor;
	}

	@Override
	@Transactional
	public Doctor updateDoctor(Doctor doctor) throws DoctorIdNotFoundException {
		Optional<Doctor> optional = null;

		optional = repository.findById(doctor.getUserId());
		if (optional.isPresent()) {
			repository.save(doctor);
		} else {
			throw new DoctorIdNotFoundException("Doctor id not found for updation");
		}
		return optional.get();
	}

	@Override
	@Transactional
	public Doctor deleteDoctor(int doctorId) throws DoctorIdNotFoundException {
		Optional<Doctor> optional = null;

		optional = repository.findById(doctorId);
		if (optional.isPresent()) {
			repository.deleteById(doctorId);
		} else {
			throw new DoctorIdNotFoundException("Doctor id not found for deletion");

		}
		return optional.get();
	}

	@Override
	public Doctor viewDoctor(int doctorId) throws DoctorIdNotFoundException {
		Optional<Doctor> optional = null;

		optional = repository.findById(doctorId);
		if (!optional.isPresent()) {
			throw new DoctorIdNotFoundException("Doctor id not found to view doctor");
		}
		return optional.get();
	}

	@Override
	public List<Doctor> viewDoctorsList() {
		List<Doctor> doctorList = null;
		try {
			doctorList = repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doctorList;
	}

	@Override
	public List<Appointment> viewAppointments() {
		List<Appointment> appointmentList = null;
		try {
			appointmentList = appointmentService.viewAllAppointments();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appointmentList;
	}

	@Override
	@Transactional
	public Test createTest(Test test) throws PatientIdFoundNotException {
		
		 Test t=testService.addTest(test);
		
		return t;
	}

}