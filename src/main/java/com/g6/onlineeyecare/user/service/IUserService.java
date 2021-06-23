package com.g6.onlineeyecare.user.service;

import java.util.List;
import com.g6.onlineeyecare.exceptions.AdminIdNotFoundException;
import com.g6.onlineeyecare.user.dto.User;

public interface IUserService {

	User addUser(User user);

	User updateUser(User user) throws AdminIdNotFoundException;

	User removeUser(int userId) throws AdminIdNotFoundException;

	User viewUser(int userId) throws AdminIdNotFoundException;

	List<User> viewUsers();
}
