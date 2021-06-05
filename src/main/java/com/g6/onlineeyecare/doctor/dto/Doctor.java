package com.g6.onlineeyecare.doctor.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.g6.onlineeyecare.user.dto.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "Doctor dto")
@Entity
@DiscriminatorValue(value = "3")
public class Doctor extends User {

	@ApiModelProperty(name = "Concultaion time", required = true)
	@Column
	@NotEmpty(message = "Consultaion time cannot be empty")
	private String doctorConsultationTime;

	@ApiModelProperty(name = "doctor mobile number", required = true)
	@Column
	private long doctorMobile;

	@ApiModelProperty(name = "doctor email", required = true)
	@Column
	@Email(message = "Email should be valid")
	@NotEmpty(message = "Email cannot be empty")
	private String doctorEmail;
	@ApiModelProperty(name = "doctor address")
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

	public Doctor() {
		super();

	}

	public Doctor(String doctorConsultationTime, long doctorMobile, String doctorEmail, String address) {
		super();

		this.doctorConsultationTime = doctorConsultationTime;
		this.doctorMobile = doctorMobile;
		this.doctorEmail = doctorEmail;
		this.address = address;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((doctorEmail == null) ? 0 : doctorEmail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (doctorEmail == null) {
			if (other.doctorEmail != null)
				return false;
		} else if (!doctorEmail.equals(other.doctorEmail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Doctor [doctorConsultationTime=" + doctorConsultationTime + ", doctorMobile=" + doctorMobile
				+ ", doctorEmail=" + doctorEmail + ", address=" + address + "]";
	}

}
