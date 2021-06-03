package com.g6.onlineeyecare.admin.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.g6.onlineeyecare.user.dto.User;

@Entity
@DiscriminatorValue(value = "2")
public class Admin extends User {

	public Admin() {
		super();
		
	}

	public Admin(int userId, String password, String userName, String role) {
		super(userId, password, userName, role);
		
	}

}
