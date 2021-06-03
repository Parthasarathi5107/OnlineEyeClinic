package com.g6.onlineeyecare.doctor.controller;

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
import com.g6.onlineeyecare.doctor.dto.Doctor;
import com.g6.onlineeyecare.doctor.service.IDoctorService;
import com.g6.onlineeyecare.exceptions.DoctorIdNotFoundException;
import com.g6.onlineeyecare.exceptions.PatientIdFoundNotException;
import com.g6.onlineeyecare.test.dto.Test;
import com.g6.onlineeyecare.test.service.ITestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(value = "Doctor Rest Controller", description = "REST APIs related to Doctor Entity!!!!")
@RestController
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	IDoctorService doctorService;
	

	@ApiOperation(value = "Create a new Doctor profile", response = Doctor.class)
	@PostMapping("/add")
	public Doctor addDoctor(@RequestBody @Valid Doctor doctor) {
		return this.doctorService.addDoctor(doctor);

	}

	@ApiOperation(value = "Update your profile", response = Doctor.class)
	@PutMapping("/update")
	public Doctor updateDoctor(@RequestBody Doctor doctor) throws DoctorIdNotFoundException {
		return this.doctorService.updateDoctor(doctor);
	}

	@ApiOperation(value = "delete your profile ", response = Doctor.class)
	@DeleteMapping("/delete/{doctorId}")
	public Doctor deleteDoctor(@PathVariable("doctorId") int doctorId) throws DoctorIdNotFoundException {
		return this.doctorService.deleteDoctor(doctorId);
	}

	@ApiOperation(value = "View Doctor profile by Id", response = Doctor.class)
	@GetMapping("/view/{doctorId}")
	public Doctor viewDoctor(@PathVariable("doctorId") int doctorId) throws DoctorIdNotFoundException {
		return this.doctorService.viewDoctor(doctorId);

	}

	@ApiOperation(value = "Get the List of Doctors", response = Doctor.class)
	@GetMapping("/viewList")
	public List<Doctor> viewDoctorsList() {
		return this.doctorService.viewDoctorsList();
	}

	@ApiOperation(value = "view all appointments", response = Doctor.class)
	@GetMapping("/viewAppointments")
	public List<Appointment> viewAppointments() {
		return this.doctorService.viewAppointments();
	}

	@ApiOperation(value = "Create a new test", response = Doctor.class)
	@PostMapping("/test")
	public Test createTest(@RequestBody Test test) throws PatientIdFoundNotException {
		return this.doctorService.createTest(test);
	}
}