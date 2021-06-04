package com.g6.onlineeyecare.report.dto;

public class ResponseReportDTO {

	private int repId;
	private String description;
	private String visAcuity;
	private String visAcuityNear;
	private String visAcuityDistance;
	private int testId;
	private int patientId;
	
	public ResponseReportDTO() {
		super();
		
	}

	public ResponseReportDTO(int repId, String description, String visAcuity, String visAcuityNear,
			String visAcuityDistance, int testId, int patientId) {
		super();
		this.repId = repId;
		this.description = description;
		this.visAcuity = visAcuity;
		this.visAcuityNear = visAcuityNear;
		this.visAcuityDistance = visAcuityDistance;
		this.testId = testId;
		this.patientId = patientId;
	}

	public int getRepId() {
		return repId;
	}

	public void setRepId(int repId) {
		this.repId = repId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVisAcuity() {
		return visAcuity;
	}

	public void setVisAcuity(String visAcuity) {
		this.visAcuity = visAcuity;
	}

	public String getVisAcuityNear() {
		return visAcuityNear;
	}

	public void setVisAcuityNear(String visAcuityNear) {
		this.visAcuityNear = visAcuityNear;
	}

	public String getVisAcuityDistance() {
		return visAcuityDistance;
	}

	public void setVisAcuityDistance(String visAcuityDistance) {
		this.visAcuityDistance = visAcuityDistance;
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
