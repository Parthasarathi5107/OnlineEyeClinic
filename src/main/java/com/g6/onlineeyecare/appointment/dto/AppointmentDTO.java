package com.g6.onlineeyecare.appointment.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.g6.onlineeyecare.doctor.dto.Doctor;
import com.g6.onlineeyecare.patient.dto.Patient;

import lombok.Data;

@Data
public class AppointmentDTO {

	private int appointmentId;
	private LocalDate appointmentDate;
	private LocalTime appointmentTime;
	private Doctor doctor;
	private Patient patient;
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
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "AppointmentEntityDTO [appointmentId=" + appointmentId + ", appointmentDate=" + appointmentDate
				+ ", appointmentTime=" + appointmentTime + ", doctor=" + doctor + ", patient=" + patient + "]";
	}
	
	

}