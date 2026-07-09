package com.boot.jpa.service;

import java.util.Date;
import java.util.HashMap;

import com.boot.jpa.dtos.GetUserResponse;
import com.boot.jpa.dtos.UserCreateRequest;
import com.boot.jpa.dtos.UserCreateResponse;
import com.boot.jpa.model.Status;
import com.boot.jpa.model.User;
import com.boot.jpa.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserService {
	
//	UserRepository userRepository = new UserRepository(); // Eager Loading, it will create the object even when not required.
	
	UserRepository userRepository;
	
	ObjectMapper objectMapper;
	
	public UserService() {								//  Inside Constructor, it is Lazy Loading, object will be created when UserService object is created
		this.userRepository = new UserRepository();
		this.objectMapper = new ObjectMapper();
	}

	public UserCreateResponse createUser(UserCreateRequest userCreateRequest) {
		
//		UserRepository userRepository = new UserRepository();
		
//		Convert DTO to Model
		User user = userCreateRequest.DtoToModel();
		
//		Save data into database/map
		user = userRepository.createUser(user);
		
//		Convert the user object got from UserRepository back from -> Model to Dto
		return UserCreateResponse.ModelToDto(user);
		
	}

	public GetUserResponse getUser(Integer id) {
		
//		UserRepository userRepository = new UserRepository();
		User user = userRepository.getUser(id);
		
//		Convert the user object got from UserRepository back from -> Model to Dto
		
		return GetUserResponse.ModelToDTO(user);
	}

	public GetUserResponse patchUser(Integer id, User incomingUser) {
		User existingUser = userRepository.getUser(id);
		
		if(null == existingUser)
			return null;
		
		if(incomingUser.getName() != null) 
			existingUser.setName(incomingUser.getName());
		
		if(incomingUser.getEmail() != null) 
			existingUser.setEmail(incomingUser.getEmail());
		
		if(incomingUser.getGender() != null) 
			existingUser.setGender(incomingUser.getGender());
		
		if(incomingUser.getAge() != null) 
			existingUser.setAge(incomingUser.getAge());
		
		existingUser.setUpdatedOn(new Date());
		 
		return GetUserResponse.ModelToDTO(existingUser);
	}
	
//	To check proper response along with record creation time and record updation time - return Complete User
	public User patchUser1(Integer id, User incomingUser) {
		User existingUser = userRepository.getUser(id);
		
		if(null == existingUser)
			return null;
		
		if(incomingUser.getName() != null) 
			existingUser.setName(incomingUser.getName());
		
		if(incomingUser.getEmail() != null) 
			existingUser.setEmail(incomingUser.getEmail());
		
		if(incomingUser.getGender() != null) 
			existingUser.setGender(incomingUser.getGender());
		
		if(incomingUser.getAge() != null) 
			existingUser.setAge(incomingUser.getAge());
		
		existingUser.setUpdatedOn(new Date());
		 
		return existingUser;
	}

	public User deleteUser(Integer id) {
		User existingUser = userRepository.getUser(id);
		if(existingUser == null)
			return null;
		
		existingUser.setStatus(Status.INACTIVE);
		
		return userRepository.deleteUser(id, existingUser);
	}
	
	
	public User patchUser2(Integer id, User incomingUser) {
		User existingUser = userRepository.getUser(id);
		
		if(null == existingUser)
			return null;
		
		User mergedUser = this.merge(incomingUser, existingUser);
		 
		return userRepository.updateUser(mergedUser);
	}

	
	@SuppressWarnings("unchecked")
	public User merge(User incomingUser, User existingUser) {
		HashMap<String, Object> incoming = this.objectMapper.convertValue(incomingUser, HashMap.class);
		HashMap<String, Object> existing = this.objectMapper.convertValue(existingUser, HashMap.class);
		
		for(String key : incoming.keySet()) {
			if(incoming.get(key) != null)
				existing.put(key, incoming.get(key));
		}
		
		return this.objectMapper.convertValue(existing, User.class);
	}
	
}
