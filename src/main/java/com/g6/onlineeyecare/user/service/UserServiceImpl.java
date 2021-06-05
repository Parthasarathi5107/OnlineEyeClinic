package com.g6.onlineeyecare.user.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
	@Transactional
	public User addUser(User user) {
		try {
			repository.save(user);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return user;
	}

	@Override
	@Transactional
	public User updateUser(User user) throws UserIdNotFoundException {
		
		Optional<User> optional = repository.findById(user.getUserId());
		if (optional.isPresent()) {
			repository.save(user);
		} else {
			throw new UserIdNotFoundException("User Id not found for updation");
		}
		return optional.get();
	}

	@Override
	@Transactional
	public User removeUser(int userId) throws UserIdNotFoundException {
		
		Optional<User> optional = repository.findById(userId);
		if (optional.isPresent()) {
			repository.deleteById(userId);
		} else {
			throw new UserIdNotFoundException("User Id not found for deletion");
		}
		return optional.get();
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

}
