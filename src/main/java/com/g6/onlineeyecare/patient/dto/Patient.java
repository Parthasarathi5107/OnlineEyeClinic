package com.g6.onlineeyecare.patient.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.g6.onlineeyecare.user.dto.User;

@Entity
@DiscriminatorValue(value = "4")
public class Patient extends User{
	
	@Column
	@Min(value=1)
	private int patientAge;
	@Column
	@NotNull
	private long patientMobile;
	@Column
	@Email(message="Email should be valid")
	@NotEmpty(message = "Email cannot be empty")
	private String patientEmail;
	@Column
	@NotNull
	private LocalDate patientDOB;
	@Column
	private String address;

	
	

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

	public void setPatientDOB( LocalDate patientDOB) {
		this.patientDOB = patientDOB;
	}

	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(int userId, String password, String userName, String role) {
		super(userId, password, userName, role);
		// TODO Auto-generated constructor stub
	}

	
	

	public Patient(int patientAge, long patientMobile, String patientEmail, LocalDate patientDOB, String address) {
		super();
		this.patientAge = patientAge;
		this.patientMobile = patientMobile;
		this.patientEmail = patientEmail;
		this.patientDOB = patientDOB;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Patient [ patientAge=" + patientAge + ", patientMobile=" + patientMobile
				+ ", patientEmail=" + patientEmail + ", patientDOB=" + patientDOB + ", address=" + address + "]";
	}
	
	
}
