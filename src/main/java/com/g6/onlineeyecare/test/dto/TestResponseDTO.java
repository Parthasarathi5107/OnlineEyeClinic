package com.g6.onlineeyecare.test.dto;

public class TestResponseDTO {

	private int tId;
	private String tName;
	private String tType;
	private String tDescription;
	private double tCost;
	private int patientId;
	
	public TestResponseDTO() {
		super();
		
	}

	public TestResponseDTO(int tId, String tName, String tType, String tDescription, double tCost, int patientId) {
		super();
		this.tId = tId;
		this.tName = tName;
		this.tType = tType;
		this.tDescription = tDescription;
		this.tCost = tCost;
		this.patientId = patientId;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettType() {
		return tType;
	}

	public void settType(String tType) {
		this.tType = tType;
	}

	public String gettDescription() {
		return tDescription;
	}

	public void settDescription(String tDescription) {
		this.tDescription = tDescription;
	}

	public double gettCost() {
		return tCost;
	}

	public void settCost(double tCost) {
		this.tCost = tCost;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	
}
