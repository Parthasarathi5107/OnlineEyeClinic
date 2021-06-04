package com.g6.onlineeyecare.appointment.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentResponseDTO {

	private int id;
	private LocalDate date;
	private LocalTime time;
	private int doctorId;
	private int patientId;
	
	public AppointmentResponseDTO() {
		super();
		
	}
	
	
	public AppointmentResponseDTO(int appId, LocalDate appDate, LocalTime appTime, int doctorId, int patientId) {
		super();
		this.id = appId;
		this.date = appDate;
		this.time = appTime;
		this.doctorId = doctorId;
		this.patientId = patientId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public LocalTime getTime() {
		return time;
	}


	public void setTime(LocalTime time) {
		this.time = time;
	}


	public int getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}


	public int getPatientId() {
		return patientId;
	}


	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}


	
	
}
