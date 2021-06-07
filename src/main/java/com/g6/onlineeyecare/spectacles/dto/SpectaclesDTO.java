package com.g6.onlineeyecare.spectacles.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.g6.onlineeyecare.patient.dto.Patient;


public class SpectaclesDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int spectaclesId;
	
	@Column
	@NotEmpty(message = "cannot be left empty")
	@Size(min = 3, max = 20)
	private String spectaclesModel;
	
	@Column
	@NotEmpty(message = "cannot be left empty")
	private String spectaclesDescription;
	
	@Column
	@Min(value = 1000, message = "cost cannot be less than 1000")
	private double spectaclesCost;

	@OneToOne
	@JoinColumn(name = "patient_Id", referencedColumnName = "userId")
	private Patient patient;
	public int getSpectaclesId() {
		return spectaclesId;
	}
	public void setSpectaclesId(int spectaclesId) {
		this.spectaclesId = spectaclesId;
	}
	public String getSpectaclesModel() {
		return spectaclesModel;
	}
	public void setSpectaclesModel(String spectaclesModel) {
		this.spectaclesModel = spectaclesModel;
	}
	public String getSpectaclesDescription() {
		return spectaclesDescription;
	}
	public void setSpectaclesDescription(String spectaclesDescription) {
		this.spectaclesDescription = spectaclesDescription;
	}
	public double getSpectaclesCost() {
		return spectaclesCost;
	}
	public void setSpectaclesCost(double spectaclesCost) {
		this.spectaclesCost = spectaclesCost;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "SpectaclesDTO [spectaclesId=" + spectaclesId + ", spectaclesModel=" + spectaclesModel
				+ ", spectaclesDescription=" + spectaclesDescription + ", spectaclesCost=" + spectaclesCost
				+ ", patient=" + patient + "]";
	}
	
	
}
