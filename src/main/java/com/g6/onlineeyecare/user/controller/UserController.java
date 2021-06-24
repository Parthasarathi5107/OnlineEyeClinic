package com.g6.onlineeyecare.user.controller;

import java.util.ArrayList;
import java.util.List;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.g6.onlineeyecare.exceptions.AdminIdNotFoundException;
import com.g6.onlineeyecare.exceptions.InvalidCredentialException;
import com.g6.onlineeyecare.user.dto.User;
import com.g6.onlineeyecare.user.dto.UserDTO;
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


	@ApiOperation(value = "view User by Id", response = User.class)
	@GetMapping("/view/{userId}")
	public ResponseEntity<UserResponseDTO> viewUser(@PathVariable("userId") int userId) throws AdminIdNotFoundException {
		
		UserResponseDTO response = modelMapper.map(this.userService.viewUser(userId), UserResponseDTO.class);
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
	
	
	@ApiOperation(value = "User Post mapping for user signing in", response = User.class)
	@PostMapping("/signin")
	public ResponseEntity<UserResponseDTO> signuser(@RequestBody UserDTO user) throws InvalidCredentialException
	{
		User actual = modelMapper.map(user, User.class);
		UserResponseDTO response = modelMapper.map(this.userService.signIn(actual), UserResponseDTO.class);
	    return new ResponseEntity<>(response, HttpStatus.RESET_CONTENT);

	}
	
	@ApiOperation(value = "User Post mapping for user signing out", response = User.class)
	@PostMapping("/signout")
	public ResponseEntity<UserResponseDTO> signoutuser() 
	{
		UserResponseDTO response = modelMapper.map(this.userService.signOut(), UserResponseDTO.class);
	    return new ResponseEntity<>(response, HttpStatus.RESET_CONTENT);

	}
}
