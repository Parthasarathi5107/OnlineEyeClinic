package com.g6.onlineeyecare.appointment.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.g6.onlineeyecare.appointment.service.IAppointmentService;
import com.g6.onlineeyecare.exceptions.AppointmentIdNotFoundException;
import com.g6.onlineeyecare.exceptions.DoctorIdNotFoundException;
import com.g6.onlineeyecare.exceptions.InvalidAppointmentException;
import com.g6.onlineeyecare.exceptions.PatientIdFoundNotException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(value = "Appointment Rest Controller", description = "REST APIs related to Appointment Entity!!!!")
@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	IAppointmentService AppointmentService;
	
	@ApiOperation(value = "Book appointment to consult the doctor",response = Appointment.class)
	@PostMapping("/book")
	public Appointment bookAppointment(@RequestBody @Valid Appointment appointment) throws DoctorIdNotFoundException, PatientIdFoundNotException
	{
		return this.AppointmentService.bookAppointment(appointment);
	}
	
	@ApiOperation(value = "Update your appointment ",response = Appointment.class)
	@PutMapping("/update")
	public Appointment updateAppointment(@RequestBody Appointment appointment) throws InvalidAppointmentException
	{
		return this.AppointmentService.updateAppointment(appointment);
	}
	
	@ApiOperation(value = "Delete the required appointment by Id ",response = Appointment.class)
	@DeleteMapping("/delete/{appointmentId}")
	public Appointment cancelAppointment(@PathVariable("appointmentId") int appointmentId) throws AppointmentIdNotFoundException 
	{
		return this.AppointmentService.cancelAppointment(appointmentId);
	}

	@ApiOperation(value = "Get the required appointment by Id ",response = Appointment.class)
	@GetMapping("/view/{appointmentId}")
	public Appointment viewAppointment(@PathVariable("appointmentId") int appointmentId) throws AppointmentIdNotFoundException
	{
		return this.AppointmentService.viewAppointment(appointmentId);
	}
	
	@ApiOperation(value = "Get the list of all appointments ",response = Appointment.class)
	@GetMapping("/viewAll")
	public List<Appointment> viewAllAppointments()
	{
		return this.AppointmentService.viewAllAppointments();
	}
	
	@ApiOperation(value = "Get the required appointment by date ",response = Appointment.class)
	@GetMapping("/viewByDate/{date}")
	public List<Appointment> viewAppointments(@PathVariable("date")@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date)
	{
		return this.AppointmentService.viewAppointments(date);
	}
	
	
}