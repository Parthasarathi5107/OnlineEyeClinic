package com.g6.onlineeyecare.appointment.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentResponseDTO {

	private int appId;
	private LocalDate appDate;
	private LocalTime appTime;
	private int doctorId;
	private int patientId;
	
	public AppointmentResponseDTO() {
		super();
		
	}
	
	
	public AppointmentResponseDTO(int appId, LocalDate appDate, LocalTime appTime, int doctorId, int patientId) {
		super();
		this.appId = appId;
		this.appDate = appDate;
		this.appTime = appTime;
		this.doctorId = doctorId;
		this.patientId = patientId;
	}


	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public LocalDate getAppDate() {
		return appDate;
	}
	public void setAppDate(LocalDate appDate) {
		this.appDate = appDate;
	}
	public LocalTime getAppTime() {
		return appTime;
	}
	public void setAppTime(LocalTime appTime) {
		this.appTime = appTime;
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
