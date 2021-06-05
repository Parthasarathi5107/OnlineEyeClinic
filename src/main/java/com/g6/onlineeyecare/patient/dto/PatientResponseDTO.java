package com.g6.onlineeyecare.patient.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PatientResponseDTO {

	private int userId;
	private int patientAge;
	private long patientMobile;
	private String patientEmail;
	private LocalDate patientDOB;
	private String address;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public long getPatientMobile() {
		return patientMobile;
	}
	public void setPatientMobile(long patientMobile) {
		this.patientMobile = patientMobile;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	public LocalDate getPatientDOB() {
		return patientDOB;
	}
	public void setPatientDOB(LocalDate patientDOB) {
		this.patientDOB = patientDOB;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "PatientResponseDTO [userId=" + userId + ", patientAge=" + patientAge + ", patientMobile="
				+ patientMobile + ", patientEmail=" + patientEmail + ", patientDOB=" + patientDOB + ", address="
				+ address + "]";
	}
	
}
