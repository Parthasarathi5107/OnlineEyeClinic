package com.g6.onlineeyecare.appointment.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentResponseDTO {

	private int appointmentId;
	private LocalDate appointmentDate;
	private LocalTime appointmentTime;
	private int doctorId;
	private int patientId;
	public AppointmentResponseDTO() {
		super();
		
	}
	public AppointmentResponseDTO(int appointmentId, LocalDate appointmentDate, LocalTime appointmentTime, int doctorId,
			int patientId) {
		super();
		this.appointmentId = appointmentId;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.doctorId = doctorId;
		this.patientId = patientId;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
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