package com.g6.onlineeyecare.patient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.g6.onlineeyecare.appointment.dto.Appointment;
import com.g6.onlineeyecare.appointment.service.IAppointmentService;
import com.g6.onlineeyecare.exceptions.AppointmentIdNotFoundException;
import com.g6.onlineeyecare.exceptions.DoctorIdNotFoundException;
import com.g6.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.g6.onlineeyecare.patient.dao.IPatientRepository;
import com.g6.onlineeyecare.patient.dto.Patient;
import com.g6.onlineeyecare.report.dao.IReportRepository;
import com.g6.onlineeyecare.report.dto.Report;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	IPatientRepository repository;
	@Autowired
	IAppointmentService appointmentService;
	@Autowired
	IReportRepository reportRepository;

	public PatientServiceImpl(IPatientRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	@Transactional
	public Patient addPatient(Patient patient) {
		try {
			repository.save(patient);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patient;
	}

	@Override
	@Transactional
	public Patient updatePatient(Patient patient) throws PatientIdFoundNotException {
		Optional<Patient> optional = null;
		optional = repository.findById(patient.getUserId());
		if (optional.isPresent()) {
			repository.save(patient);
		} else {
			throw new PatientIdFoundNotException("Patient ID not found for updation");
		}
		return optional.get();
	}

	@Override
	@Transactional
	public Patient deletePatient(int patientId) throws PatientIdFoundNotException {
		Optional<Patient> optional = null;
		optional = repository.findById(patientId);
		if (optional.isPresent()) {
			repository.deleteById(patientId);
		} else {
			throw new PatientIdFoundNotException("Patient id not found for deletion");
		}
		return optional.get();
	}

	@Override
	public List<Patient> viewPatientList() {
		List<Patient> patientList = null;
		try {
			patientList = repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patientList;
	}

	@Override
	public Patient viewPatient(int patientId) throws PatientIdFoundNotException {
		Optional<Patient> optional = null;

		optional = repository.findById(patientId);
		if (!optional.isPresent()) {
			throw new PatientIdFoundNotException("Patient id not found to view patient");
		}
		return optional.get();
	}

	@Override
	@Transactional
	public Appointment bookAppointment(Appointment appointment) throws DoctorIdNotFoundException, PatientIdFoundNotException {
		
			Appointment a=appointmentService.bookAppointment(appointment);
		
		return a;
	}

	@Override
	public Appointment viewAppointmentDetails(int appointmentid) throws AppointmentIdNotFoundException {
		Appointment appointment = null;
		try {
			appointment = appointmentService.viewAppointment(appointmentid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppointmentIdNotFoundException("Appointment Id not found to view appointment");
		}
		return appointment;
	}

	@Override
	public List<Report> viewReport(int patientId) throws PatientIdFoundNotException {
		List<Report> reports = null;
		reports = reportRepository.findReportByPatientId(patientId);
		if (reports.isEmpty()) {
			throw new PatientIdFoundNotException("Patient Id not found to view the report");
		}
		return reports;
	}

}
