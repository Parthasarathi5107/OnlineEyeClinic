package com.g6.onlineeyecare.user.controller;

import java.util.ArrayList;
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
import com.g6.onlineeyecare.admin.dto.AdminDTO;
import com.g6.onlineeyecare.exceptions.UserIdNotFoundException;
import com.g6.onlineeyecare.user.dto.User;
import com.g6.onlineeyecare.user.dto.UserResponseDTO;
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
	public ResponseEntity<UserResponseDTO> addUser(@RequestBody @Valid AdminDTO user) {
		
		Admin actual = modelMapper.map(user, Admin.class);
		UserResponseDTO response = modelMapper.map(this.userService.addUser(actual), UserResponseDTO.class);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "view User by Id", response = User.class)
	@GetMapping("/view/{userId}")
	public ResponseEntity<UserResponseDTO> viewUser(@PathVariable("userId") int userId) throws UserIdNotFoundException {
		
		UserResponseDTO response = modelMapper.map(this.userService.viewUser(userId), UserResponseDTO.class);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "update profile", response = User.class)
	@PutMapping("/update")
	public ResponseEntity<UserResponseDTO> updateUser(@RequestBody  AdminDTO user) throws UserIdNotFoundException {
		
		Admin actual = modelMapper.map(user, Admin.class);
		UserResponseDTO response = modelMapper.map(this.userService.updateUser(actual), UserResponseDTO.class);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "delete user", response = User.class)
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<UserResponseDTO> removeUser(@PathVariable("userId") int userId) throws UserIdNotFoundException {
		
		UserResponseDTO response = modelMapper.map(this.userService.removeUser(userId), UserResponseDTO.class);
		if (response != null) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "view all Users", response = User.class)
	@GetMapping("/viewAll")
	public ResponseEntity<List<UserResponseDTO>> viewUsers() {
		
		List<User> userList = this.userService.viewUsers();
		List<UserResponseDTO> userDtoList = new ArrayList<>();
		for (User u : userList) {
			UserResponseDTO userDto = modelMapper.map(u , UserResponseDTO.class);
			userDtoList.add(userDto);
		}
		if (!(userDtoList.isEmpty())) {
			return new ResponseEntity<>(userDtoList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(userDtoList, HttpStatus.BAD_REQUEST);
		}
	}
}
