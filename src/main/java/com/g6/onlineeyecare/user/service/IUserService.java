package com.g6.onlineeyecare.user.service;

import java.util.List;
import com.g6.onlineeyecare.exceptions.UserIdNotFoundException;
import com.g6.onlineeyecare.user.dto.User;


public interface IUserService {

    User addUser(User user);
	
	User updateUser(User user)throws UserIdNotFoundException;
	
	User removeUser(int userId)throws UserIdNotFoundException;
	
	User viewUser(int userId)throws UserIdNotFoundException;
	
	List<User>viewUsers();
}
