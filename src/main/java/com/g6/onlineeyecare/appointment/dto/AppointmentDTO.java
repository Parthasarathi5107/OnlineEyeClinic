package com.g6.onlineeyecare.appointment.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;

import com.g6.onlineeyecare.doctor.dto.Doctor;
import com.g6.onlineeyecare.patient.dto.Patient;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AppointmentDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmentId;

	@ApiModelProperty(name = "Appointment date", required = true)
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate appointmentDate;

	@ApiModelProperty(name = "Appointment time", required = true)
	@Column
	private LocalTime appointmentTime;

	@OneToOne
	@JoinColumn(name = "doctor_Id", referencedColumnName = "userId")
	@Valid
	private Doctor doctor;

	@OneToOne
	@JoinColumn(name = "patient_Id", referencedColumnName = "userId")
	@Valid
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
