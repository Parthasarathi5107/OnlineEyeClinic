package com.g6.onlineeyecare.report.dto;

public class ResponseReportDTO {

	private int id;
	private String description;
	private String visualAcuityDetails;
	private String visualAcuityNearDetails;
	private String visualAcuityDistanceDetails;
	private int testId;
	private int patientId;
	
	public ResponseReportDTO() {
		super();
		
	}

	public ResponseReportDTO(int repId, String description, String visAcuity, String visAcuityNear,
			String visAcuityDistance, int testId, int patientId) {
		super();
		this.id = repId;
		this.description = description;
		this.visualAcuityDetails = visAcuity;
		this.visualAcuityNearDetails = visAcuityNear;
		this.visualAcuityDistanceDetails = visAcuityDistance;
		this.testId = testId;
		this.patientId = patientId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVisualAcuityDetails() {
		return visualAcuityDetails;
	}

	public void setVisualAcuityDetails(String visualAcuityDetails) {
		this.visualAcuityDetails = visualAcuityDetails;
	}

	public String getVisualAcuityNearDetails() {
		return visualAcuityNearDetails;
	}

	public void setVisualAcuityNearDetails(String visualAcuityNearDetails) {
		this.visualAcuityNearDetails = visualAcuityNearDetails;
	}

	public String getVisualAcuityDistanceDetails() {
		return visualAcuityDistanceDetails;
	}

	public void setVisualAcuityDistanceDetails(String visualAcuityDistanceDetails) {
		this.visualAcuityDistanceDetails = visualAcuityDistanceDetails;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	
}
