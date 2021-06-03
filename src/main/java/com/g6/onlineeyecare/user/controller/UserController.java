package com.g6.onlineeyecare.user.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.g6.onlineeyecare.user.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Validated
@Api(value = "User Rest Controller")
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	IUserService userService;

	@ApiOperation(value = "add a new User", response = User.class)
	@PostMapping("/add")
	public Admin addUser(@RequestBody @Valid Admin user) {
		return (Admin) this.userService.addUser(user);
	}

	@ApiOperation(value = "view User by Id", response = User.class)
	@GetMapping("/view/{userId}")
	public Admin viewUser(@PathVariable("userId") int userId) throws UserIdNotFoundException {
		return (Admin) this.userService.viewUser(userId);

	}

	@ApiOperation(value = "update profile", response = User.class)
	@PutMapping("/update")
	public Admin updateUser(@RequestBody Admin user) throws UserIdNotFoundException {
		return (Admin) this.userService.updateUser(user);
	}

	@ApiOperation(value = "delete user", response = User.class)
	@DeleteMapping("/delete/{userId}")
	public Admin removeUser(@PathVariable("userId") int userId) throws UserIdNotFoundException {
		return (Admin) this.userService.removeUser(userId);
	}

	@ApiOperation(value = "view all Users", response = User.class)
	@GetMapping("/viewAll")
	public List<User> viewUsers() {
		return this.userService.viewUsers();
	}
}
