package com.g6.onlineeyecare.test.dto;

public class TestResponseDTO {

	private int id;
	private String name;
	private String typeOfTest;
	private String description;
	private double cost;
	private int patientId;
	
	public TestResponseDTO() {
		super();
		
	}

	public TestResponseDTO(int tId, String tName, String tType, String tDescription, double tCost, int patientId) {
		super();
		this.id = tId;
		this.name = tName;
		this.typeOfTest = tType;
		this.description = tDescription;
		this.cost = tCost;
		this.patientId = patientId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeOfTest() {
		return typeOfTest;
	}

	public void setTypeOfTest(String typeOfTest) {
		this.typeOfTest = typeOfTest;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	
}
