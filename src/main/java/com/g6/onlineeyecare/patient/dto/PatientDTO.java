package com.g6.onlineeyecare.patient.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.g6.onlineeyecare.user.dto.UserDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class PatientDTO extends UserDTO{

	@ApiModelProperty(name = "Patient age", required = true)
	@Column
	@Min(value = 1)
	private int patientAge;
	
	@ApiModelProperty(name = "Patient mobile number", required = true)
	@Column
	private long patientMobile;
	
	@ApiModelProperty(name = "Patient Email", required = true)
	@Column
	@Email(message = "Email should be valid")
	@NotEmpty(message = "Email cannot be empty")
	private String patientEmail;
	@ApiModelProperty(name = "Patient DOB", required = true)
	@Column
	private LocalDate patientDOB;
	@ApiModelProperty(name = "Patient address")
	@Column
	@Size(max = 512, message = "Patient address cannot be more than 512 characters")
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
		return "PatientDTO [patientAge=" + patientAge + ", patientMobile=" + patientMobile + ", patientEmail="
				+ patientEmail + ", patientDOB=" + patientDOB + ", address=" + address + "]";
	}
	
	
}
