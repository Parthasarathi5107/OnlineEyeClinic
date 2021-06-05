package com.g6.onlineeyecare.user.dto;

public class UserEntityDTO {

	private int userId;
	private String password;
	private String userName;
	private String role;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	@Override
	public String toString() {
		return "UserEntityDTO [userId=" + userId + ", password=" + password + ", userName=" + userName + ", role="
				+ role + "]";
	}
	
	
}
