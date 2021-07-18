package com.g6.onlineeyecare.user.dto;

public class UserResponseDTO {

	private int userId;
	private String userName;
	private String role;
	private String password;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserResponseDTO [userId=" + userId + ", userName=" + userName + ", role=" + role + ", password="
				+ password + "]";
	}
	
	
}
