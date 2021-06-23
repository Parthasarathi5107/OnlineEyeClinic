package com.g6.onlineeyecare.user.service;

import java.util.List;

import com.g6.onlineeyecare.exceptions.InvalidCredentialException;
import com.g6.onlineeyecare.exceptions.UserIdNotFoundException;
import com.g6.onlineeyecare.user.dto.User;

public interface IUserService {

	
	User viewUser(int userId) throws UserIdNotFoundException;

	List<User> viewUsers();
	
	public User signIn(User user) throws InvalidCredentialException;
	
	public User signOut(User user);
}
