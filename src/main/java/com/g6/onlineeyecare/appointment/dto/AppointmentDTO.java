package com.g6.onlineeyecare.appointment.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.g6.onlineeyecare.doctor.dto.Doctor;
import com.g6.onlineeyecare.patient.dto.Patient;


public class AppointmentDTO {

	private int appointmentId;
	private LocalDate appointmentDate;
	private LocalTime appointmentTime;
//	private Doctor doctor;
//	private Patient patient;
	private int doctorId;
	private int patientId;
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
