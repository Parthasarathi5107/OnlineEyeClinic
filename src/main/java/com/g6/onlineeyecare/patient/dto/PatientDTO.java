package com.g6.onlineeyecare.patient.dto;

import java.time.LocalDate;

public class PatientDTO {

	private int dtoPatientAge;
	private long dtoPatientMobile;
	private String dtoPatientEmail;
	private LocalDate dtoPatientDOB;
	private String dtoAddress;
	public PatientDTO() {
		super();
		
	}
	public PatientDTO(int dtoPatientAge, long dtoPatientMobile, String dtoPatientEmail, LocalDate dtoPatientDOB,
			String dtoAddress) {
		super();
		this.dtoPatientAge = dtoPatientAge;
		this.dtoPatientMobile = dtoPatientMobile;
		this.dtoPatientEmail = dtoPatientEmail;
		this.dtoPatientDOB = dtoPatientDOB;
		this.dtoAddress = dtoAddress;
	}
	public int getDtoPatientAge() {
		return dtoPatientAge;
	}
	public void setDtoPatientAge(int dtoPatientAge) {
		this.dtoPatientAge = dtoPatientAge;
	}
	public long getDtoPatientMobile() {
		return dtoPatientMobile;
	}
	public void setDtoPatientMobile(long dtoPatientMobile) {
		this.dtoPatientMobile = dtoPatientMobile;
	}
	public String getDtoPatientEmail() {
		return dtoPatientEmail;
	}
	public void setDtoPatientEmail(String dtoPatientEmail) {
		this.dtoPatientEmail = dtoPatientEmail;
	}
	public LocalDate getDtoPatientDOB() {
		return dtoPatientDOB;
	}
	public void setDtoPatientDOB(LocalDate dtoPatientDOB) {
		this.dtoPatientDOB = dtoPatientDOB;
	}
	public String getDtoAddress() {
		return dtoAddress;
	}
	public void setDtoAddress(String dtoAddress) {
		this.dtoAddress = dtoAddress;
	}
	
	
}
