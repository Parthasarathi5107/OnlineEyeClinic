package com.g6.onlineeyecare.doctor.dto;


import com.g6.onlineeyecare.user.dto.UserEntityDTO;

import lombok.Data;

@Data
public class DoctorEntityDTO extends UserEntityDTO{

	
	private String doctorConsultationTime;
	private long doctorMobile;
	private String doctorEmail;
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
