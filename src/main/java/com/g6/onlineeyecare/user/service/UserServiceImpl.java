package com.g6.onlineeyecare.user.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g6.onlineeyecare.exceptions.InvalidCredentialException;
import com.g6.onlineeyecare.exceptions.UserIdNotFoundException;

import com.g6.onlineeyecare.user.dao.IUserRepository;
import com.g6.onlineeyecare.user.dto.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository repository;

	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	public UserServiceImpl(IUserRepository repository) {
		super();
		this.repository = repository;
	}


	@Override
	public User viewUser(int userId) throws UserIdNotFoundException {
		
		Optional<User> optional = repository.findById(userId);
		if (!optional.isPresent()) {
			throw new UserIdNotFoundException("User Id not found to view user");
		}
		return optional.get();
	}

	@Override
	public List<User> viewUsers() {
		List<User> userList = null;
		try {
			userList = repository.findAll();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return userList;
	}
	
//	@Override
//	public User signIn(User user) throws InvalidCredentialException {
//		
//		Optional<User> opt = repository.findById(user.getUserId());
//		try {
//			if (opt.isPresent()) {
//				User u = opt.get();
//				boolean matched = BCrypt.checkpw(user.getPassword(), u.getPassword());
//				if (matched) {
//					return u;
//
//				} else {
//					throw new InvalidCredentialException("Invalid password");
//				}
//			} else {
//				throw new InvalidCredentialException("Invalid userID");
//			}
//		} catch (Exception e) {
//			throw new InvalidCredentialException("Invalid username or password");
//		}
//	}
	
	@Override
	public User signOut(User user) {

		return null;
	}

	@Override
	public User signIn(User user) throws InvalidCredentialException {
		return null;
	}

}
