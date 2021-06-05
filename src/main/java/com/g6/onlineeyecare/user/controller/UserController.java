package com.g6.onlineeyecare.user.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.g6.onlineeyecare.admin.dto.Admin;
import com.g6.onlineeyecare.exceptions.UserIdNotFoundException;
import com.g6.onlineeyecare.user.dto.User;
import com.g6.onlineeyecare.user.dto.UserDTO;
import com.g6.onlineeyecare.user.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(value = "User Rest Controller")
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	IUserService userService;

	@ApiOperation(value = "add a new User", response = User.class)
	@PostMapping("/add")
	public ResponseEntity<UserDTO> addUser(@RequestBody @Valid UserDTO user) {
		User u = modelMapper.map(user, User.class);
		User req = userService.addUser(u);
		UserDTO response = modelMapper.map(req, UserDTO.class); 
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "view User by Id", response = User.class)
	@GetMapping("/view/{userId}")
	public ResponseEntity<User> viewUser(@PathVariable("userId") int userId) throws UserIdNotFoundException {
		User u =  this.userService.viewUser(userId);
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
//============================================================================================================================
	@ApiOperation(value = "update profile", response = User.class)
	@PutMapping("/update")
	public ResponseEntity<Admin> updateUser(@RequestBody  Admin user) throws UserIdNotFoundException {
		Admin u =  (Admin) this.userService.updateUser(user);
		return new ResponseEntity<>(u, HttpStatus.OK);
	}

	@ApiOperation(value = "delete user", response = User.class)
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<User> removeUser(@PathVariable("userId") int userId) throws UserIdNotFoundException {
		User u =  this.userService.removeUser(userId);
		return new ResponseEntity<>(u, HttpStatus.OK);
	}

	@ApiOperation(value = "view all Users", response = User.class)
	@GetMapping("/viewAll")
	public ResponseEntity<List<User>> viewUsers() {
		List<User> u = this.userService.viewUsers();
		return new ResponseEntity<>(u, HttpStatus.OK);
	}
}
