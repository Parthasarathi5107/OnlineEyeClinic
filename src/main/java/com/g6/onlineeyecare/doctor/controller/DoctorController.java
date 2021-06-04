package com.g6.onlineeyecare.doctor.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.g6.onlineeyecare.appointment.dto.AppointmentResponseDTO;
import com.g6.onlineeyecare.doctor.dto.Doctor;
import com.g6.onlineeyecare.doctor.service.IDoctorService;
import com.g6.onlineeyecare.exceptions.DoctorIdNotFoundException;
import com.g6.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.g6.onlineeyecare.test.dto.Test;
import com.g6.onlineeyecare.test.dto.TestResponseDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(value = "Doctor Rest Controller")
@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	IDoctorService doctorService;

	@ApiOperation(value = "Create a new Doctor profile", response = Doctor.class)
	@PostMapping("/add")
	public ResponseEntity<Doctor> addDoctor(@RequestBody @Valid Doctor doctor) {
		Doctor d = this.doctorService.addDoctor(doctor);
		return new ResponseEntity<>(d, HttpStatus.OK);
	}

	@ApiOperation(value = "Update your profile", response = Doctor.class)
	@PutMapping("/update")
	public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) throws DoctorIdNotFoundException {
		Doctor d = this.doctorService.updateDoctor(doctor);
		return new ResponseEntity<>(d, HttpStatus.OK);
	}

	@ApiOperation(value = "delete your profile ", response = Doctor.class)
	@DeleteMapping("/delete/{doctorId}")
	public ResponseEntity<Doctor> deleteDoctor(@PathVariable("doctorId") int doctorId)
			throws DoctorIdNotFoundException {
		Doctor d = this.doctorService.deleteDoctor(doctorId);
		return new ResponseEntity<>(d, HttpStatus.OK);
	}

	@ApiOperation(value = "View Doctor profile by Id", response = Doctor.class)
	@GetMapping("/view/{doctorId}")
	public ResponseEntity<Doctor> viewDoctor(@PathVariable("doctorId") int doctorId) throws DoctorIdNotFoundException {
		Doctor d = this.doctorService.viewDoctor(doctorId);
		return new ResponseEntity<>(d, HttpStatus.OK);

	}

	@ApiOperation(value = "Get the List of Doctors", response = Doctor.class)
	@GetMapping("/viewAll")
	public ResponseEntity<List<Doctor>> viewDoctorsList() {
		List<Doctor> d = this.doctorService.viewDoctorsList();
		return new ResponseEntity<>(d, HttpStatus.OK);
	}

	@ApiOperation(value = "view all appointments", response = Doctor.class)
	@GetMapping("/viewAppointments")
	public ResponseEntity<List<AppointmentResponseDTO>> viewAppointments() {
		List<Appointment> appointmentList = this.doctorService.viewAppointments();
		List<AppointmentResponseDTO> alist = new ArrayList<>();
		for (Appointment a : appointmentList) {
			AppointmentResponseDTO response = new AppointmentResponseDTO(a.getAppointmentId(), a.getAppointmentDate(),
					a.getAppointmentTime(), a.getDoctor().getUserId(), a.getPatient().getUserId());
			alist.add(response);
		}
		return new ResponseEntity<>(alist, HttpStatus.OK);
	}

	@ApiOperation(value = "Create a new test", response = Doctor.class)
	@PostMapping("/test")
	public ResponseEntity<TestResponseDTO> createTest(@RequestBody Test test) throws PatientIdFoundNotException {
		Test t = this.doctorService.createTest(test);
		TestResponseDTO response = new TestResponseDTO(t.getTestId(), t.getTestName(), t.getTestType(),
				t.getTestDescription(), t.getTestCost(), t.getPatient().getUserId());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}