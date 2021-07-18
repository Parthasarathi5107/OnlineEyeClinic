package com.g6.onlineeyecare.user.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.g6.onlineeyecare.exceptions.InvalidCredentialException;
import com.g6.onlineeyecare.exceptions.AdminIdNotFoundException;

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
	public User viewUser(int userId) throws AdminIdNotFoundException {

		Optional<User> optional = repository.findById(userId);
		if (!optional.isPresent()) {
			throw new AdminIdNotFoundException("User Id not found to view user");
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

	@Override
    public User signIn(User user) throws InvalidCredentialException {
        Optional<User> optional = repository.findById(user.getUserId());
        User loggedInUser = null;
        if (optional.isPresent()) {
            if (optional.get().getPassword().equals(user.getPassword())&&(optional.get().getRole().equals(user.getRole()) )
                    &&(optional.get().getUserName().equals(user.getUserName()) )) {
                loggedInUser = optional.get();
            } else {
                throw new InvalidCredentialException("Invalid userId or password");
            }
        } else {
            throw new InvalidCredentialException("Invalid userId");
        }
        return loggedInUser;
    }
	@Override
	public User signOut() {
		
		return null;
	}
	
}
