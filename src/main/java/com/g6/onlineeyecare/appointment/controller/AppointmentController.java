package com.g6.onlineeyecare.appointment.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.g6.onlineeyecare.appointment.dto.AppointmentResponseDTO;
import com.g6.onlineeyecare.appointment.service.IAppointmentService;
import com.g6.onlineeyecare.exceptions.AppointmentIdNotFoundException;
import com.g6.onlineeyecare.exceptions.DoctorIdNotFoundException;
import com.g6.onlineeyecare.exceptions.InvalidAppointmentException;
import com.g6.onlineeyecare.exceptions.PatientIdFoundNotException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(value = "Appointment Rest Controller")
@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	IAppointmentService appointmentService;
	
	@ApiOperation(value = "Book appointment to consult the doctor",response = Appointment.class)
	@PostMapping("/book")
	public  ResponseEntity<AppointmentResponseDTO> bookAppointment(@RequestBody @Valid Appointment appointment) throws DoctorIdNotFoundException, PatientIdFoundNotException
	{
		Appointment a = appointmentService.bookAppointment(appointment);
		AppointmentResponseDTO response = new AppointmentResponseDTO(a.getAppointmentId(), a.getAppointmentDate(), a.getAppointmentTime(),
				a.getDoctor().getUserId(), a.getPatient().getUserId());
		
		return new ResponseEntity<AppointmentResponseDTO>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update your appointment ",response = Appointment.class)
	@PutMapping("/update")
	public ResponseEntity<AppointmentResponseDTO> updateAppointment(@RequestBody Appointment appointment) throws InvalidAppointmentException
	{
		Appointment a = appointmentService.updateAppointment(appointment);
		AppointmentResponseDTO response = new AppointmentResponseDTO(a.getAppointmentId(), a.getAppointmentDate(), a.getAppointmentTime(),
				a.getDoctor().getUserId(), a.getPatient().getUserId());
		
		return new ResponseEntity<AppointmentResponseDTO>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete the required appointment by Id ",response = Appointment.class)
	@DeleteMapping("/delete/{appointmentId}")
	public ResponseEntity<AppointmentResponseDTO> cancelAppointment(@PathVariable("appointmentId") int appointmentId) throws AppointmentIdNotFoundException 
	{
		Appointment a =  this.appointmentService.cancelAppointment(appointmentId);
		AppointmentResponseDTO response = new AppointmentResponseDTO(a.getAppointmentId(), a.getAppointmentDate(), a.getAppointmentTime(),
				a.getDoctor().getUserId(), a.getPatient().getUserId());
		
		return new ResponseEntity<AppointmentResponseDTO>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Get the required appointment by Id ",response = Appointment.class)
	@GetMapping("/view/{appointmentId}")
	public ResponseEntity<AppointmentResponseDTO> viewAppointment(@PathVariable("appointmentId") int appointmentId) throws AppointmentIdNotFoundException
	{
		Appointment a = this.appointmentService.viewAppointment(appointmentId);
		AppointmentResponseDTO response = new AppointmentResponseDTO(a.getAppointmentId(), a.getAppointmentDate(), a.getAppointmentTime(),
				a.getDoctor().getUserId(), a.getPatient().getUserId());
		
		return new ResponseEntity<AppointmentResponseDTO>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get the list of all appointments ",response = Appointment.class)
	@GetMapping("/viewAll")
	public ResponseEntity<List<AppointmentResponseDTO>> viewAllAppointments()
	{
		List<Appointment> appointmentList =  this.appointmentService.viewAllAppointments();
		List<AppointmentResponseDTO> alist = new ArrayList<>();
		for (Appointment a : appointmentList) {
			AppointmentResponseDTO response = new AppointmentResponseDTO(a.getAppointmentId(), a.getAppointmentDate(), a.getAppointmentTime(),
					a.getDoctor().getUserId(), a.getPatient().getUserId());
			alist.add(response);
		}
			return new ResponseEntity<>(alist, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get the required appointment by date ",response = Appointment.class)
	@GetMapping("/viewByDate/{date}")
	public ResponseEntity<List<AppointmentResponseDTO>> viewAppointments(@PathVariable("date")@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date)
	{
		List<Appointment> appointmentList = this.appointmentService.viewAppointments(date);
		List<AppointmentResponseDTO> alist = new ArrayList<>();
		for (Appointment a : appointmentList) {
			AppointmentResponseDTO response = new AppointmentResponseDTO(a.getAppointmentId(), a.getAppointmentDate(), a.getAppointmentTime(),
					a.getDoctor().getUserId(), a.getPatient().getUserId());
			alist.add(response);
		}
			return new ResponseEntity<>(alist, HttpStatus.OK);
	}
	
	
}