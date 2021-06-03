package com.g6.onlineeyecare.patient.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g6.onlineeyecare.appointment.dto.Appointment;
import com.g6.onlineeyecare.exceptions.AppointmentIdNotFoundException;
import com.g6.onlineeyecare.exceptions.DoctorIdNotFoundException;
import com.g6.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.g6.onlineeyecare.patient.dto.Patient;
import com.g6.onlineeyecare.patient.service.IPatientService;
import com.g6.onlineeyecare.report.dto.Report;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(value = "Patient Rest Controller")
@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	IPatientService patientService;

	@ApiOperation(value = "create a new Patient profile", response = Patient.class)
	@PostMapping("/add")
	public Patient addPatient(@RequestBody @Valid Patient patient) {
		return this.patientService.addPatient(patient);

	}

	@ApiOperation(value = "Update your profile ", response = Patient.class)
	@PutMapping("/update")
	public Patient updatePatient(@RequestBody Patient patient) throws PatientIdFoundNotException {
		return this.patientService.updatePatient(patient);
	}

	@ApiOperation(value = "Delete your profile ", response = Patient.class)
	@DeleteMapping("/delete/{patientId}")
	public Patient deletePatient(@PathVariable("patientId") int patientId) throws PatientIdFoundNotException {
		return this.patientService.deletePatient(patientId);
	}

	@ApiOperation(value = "view Patient profile by Id", response = Patient.class)
	@GetMapping("/view/{patientId}")
	public Patient viewPatient(@PathVariable("patientId") int patientId) throws PatientIdFoundNotException {
		return this.patientService.viewPatient(patientId);

	}

	@ApiOperation(value = "view list of Patients ", response = Patient.class)
	@GetMapping("/viewPatientList")
	public List<Patient> viewPatientList() {
		return this.patientService.viewPatientList();
	}

	@ApiOperation(value = "Book appointment to consult the doctor", response = Appointment.class)
	@PostMapping("/book")
	public Appointment bookAppointment(@RequestBody Appointment appointment) throws DoctorIdNotFoundException, PatientIdFoundNotException {
		return this.patientService.bookAppointment(appointment);

	}

	@ApiOperation(value = "Get the required appointment by Id ", response = Appointment.class)
	@GetMapping("/viewAppointmentDetails/{appointmentId}")
	public Appointment viewAppointmentDetails(@PathVariable("appointmentId") int appointmentid)
			throws AppointmentIdNotFoundException {
		return this.patientService.viewAppointmentDetails(appointmentid);
	}

	@ApiOperation(value = "Get the required Report by patientId ", response = Report.class)
	@GetMapping("/report/{patientId}")
	public List<Report> viewReport(@PathVariable("patientId") int patientId) throws PatientIdFoundNotException {
		return this.patientService.viewReport(patientId);
	}
}
