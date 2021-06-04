package com.g6.onlineeyecare.spectacles.dto;

public class SpectaclesResponseDTO {

	private int specsId;
	private String specsModel;
	private String specsDescription;
	private double specsCost;
	private int patientId;
	
	public SpectaclesResponseDTO() {
		super();
		
	}

	public SpectaclesResponseDTO(int specsId, String specsModel, String specsDescription, double specsCost,
			int patientId) {
		super();
		this.specsId = specsId;
		this.specsModel = specsModel;
		this.specsDescription = specsDescription;
		this.specsCost = specsCost;
		this.patientId = patientId;
	}

	public int getSpecsId() {
		return specsId;
	}

	public void setSpecsId(int specsId) {
		this.specsId = specsId;
	}

	public String getSpecsModel() {
		return specsModel;
	}

	public void setSpecsModel(String specsModel) {
		this.specsModel = specsModel;
	}

	public String getSpecsDescription() {
		return specsDescription;
	}

	public void setSpecsDescription(String specsDescription) {
		this.specsDescription = specsDescription;
	}

	public double getSpecsCost() {
		return specsCost;
	}

	public void setSpecsCost(double specsCost) {
		this.specsCost = specsCost;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	
}
