package com.g6.onlineeyecare.doctor.dto;


import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.g6.onlineeyecare.user.dto.UserDTO;

public class DoctorDTO extends UserDTO{

	
	
	@Column
	@NotEmpty(message = "Consultaion time cannot be empty")
	private String doctorConsultationTime;

	
	@Column
	private long doctorMobile;

	
	@Column
	@Email(message = "Email should be valid")
	@NotEmpty(message = "Email cannot be empty")
	private String doctorEmail;
	
	@Column
	@Size(max = 512, message = "doctor address cannot be more than 512 characters")
	private String address;

	
	
	public String getDoctorConsultationTime() {
		return doctorConsultationTime;
	}
	public void setDoctorConsultationTime(String doctorConsultationTime) {
		this.doctorConsultationTime = doctorConsultationTime;
	}
	public long getDoctorMobile() {
		return doctorMobile;
	}
	public void setDoctorMobile(long doctorMobile) {
		this.doctorMobile = doctorMobile;
	}
	public String getDoctorEmail() {
		return doctorEmail;
	}
	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "DoctorEntityDTO [doctorConsultationTime=" + doctorConsultationTime + ", doctorMobile=" + doctorMobile
				+ ", doctorEmail=" + doctorEmail + ", address=" + address + "]";
	}
	
	
	
}
