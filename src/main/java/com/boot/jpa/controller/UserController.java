package com.boot.jpa.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.jpa.dtos.GetUserResponse;
import com.boot.jpa.dtos.UserCreateRequest;
import com.boot.jpa.dtos.UserCreateResponse;
import com.boot.jpa.dtos.UserUpdateRequest;
import com.boot.jpa.model.User;
import com.boot.jpa.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	UserService userService;
	
	public UserController() {
		this.userService = new UserService();
	}
	
//	Create User
	@PostMapping("/create")
	public UserCreateResponse createUser(@RequestBody UserCreateRequest userCreateRequest) {
		
//		UserService userService = new UserService(); // Commented because its declared globally at class level.
		return userService.createUser(userCreateRequest);
		
	}
	
//	Fetch User Details
	@GetMapping("/get")
	public GetUserResponse getUser(@RequestParam Integer id) {
		
//		UserService userService = new UserService();
		return userService.getUser(id);
		
	}
	
//	Update User Details
	@PatchMapping("/patch")
	public GetUserResponse patchUser(@RequestParam Integer id, @RequestBody UserUpdateRequest userUpdateRequest) {
		
		return userService.patchUser(id, userUpdateRequest.DtoToModel());
	}
	
//	First Update User Details and then check proper response along with record creation time and record updation time
	@PatchMapping("/patch1")
	public User patchUser1(@RequestParam Integer id, @RequestBody UserUpdateRequest userUpdateRequest) {
		
		return userService.patchUser1(id, userUpdateRequest.DtoToModel());
	}

//	Perform Soft Delete
	@DeleteMapping("/delete")
	public User deleteUser(@RequestParam Integer id) {
		
		return userService.deleteUser(id);
		
	}
	
//	Update User Details, Use ObjectMapper to iterate all the fields coming for Update
	@PatchMapping("/patch2")
	public User patchUser2(@RequestParam Integer id, @RequestBody UserUpdateRequest userUpdateRequest) {
		
		return userService.patchUser2(id, userUpdateRequest.DtoToModel());
	}
	
}
