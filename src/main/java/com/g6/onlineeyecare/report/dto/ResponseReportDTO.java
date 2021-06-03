package com.g6.onlineeyecare.report.dto;

public class ResponseReportDTO {

	private int reportId;
	private String descriptionOfReport;
	private String visualAcuity;
	private String visualAcuityNear;
	private String visualAcuityDistance;
	private int testId;
	private int patientId;
	
	public ResponseReportDTO() {
		super();
		
	}

	public ResponseReportDTO(int reportId, String descriptionOfReport, String visualAcuity, String visualAcuityNear,
			String visualAcuityDistance, int testId, int patientId) {
		super();
		this.reportId = reportId;
		this.descriptionOfReport = descriptionOfReport;
		this.visualAcuity = visualAcuity;
		this.visualAcuityNear = visualAcuityNear;
		this.visualAcuityDistance = visualAcuityDistance;
		this.testId = testId;
		this.patientId = patientId;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getDescriptionOfReport() {
		return descriptionOfReport;
	}

	public void setDescriptionOfReport(String descriptionOfReport) {
		this.descriptionOfReport = descriptionOfReport;
	}

	public String getVisualAcuity() {
		return visualAcuity;
	}

	public void setVisualAcuity(String visualAcuity) {
		this.visualAcuity = visualAcuity;
	}

	public String getVisualAcuityNear() {
		return visualAcuityNear;
	}

	public void setVisualAcuityNear(String visualAcuityNear) {
		this.visualAcuityNear = visualAcuityNear;
	}

	public String getVisualAcuityDistance() {
		return visualAcuityDistance;
	}

	public void setVisualAcuityDistance(String visualAcuityDistance) {
		this.visualAcuityDistance = visualAcuityDistance;
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
