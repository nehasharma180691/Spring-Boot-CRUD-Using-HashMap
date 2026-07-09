package com.boot.jpa.dtos;

import com.boot.jpa.model.Gender;
import com.boot.jpa.model.Status;
import com.boot.jpa.model.User;

public class GetUserResponse {
	
	private String name;
	private String email;
	private Integer age;
	private Gender gender;
	private Status status; 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public static GetUserResponse ModelToDTO(User user) {
		
		if(user == null)
			return null;
		
		GetUserResponse getUserResponse = new GetUserResponse();
		getUserResponse.setName(user.getName());
		getUserResponse.setEmail(user.getEmail());
		getUserResponse.setAge(user.getAge());
		getUserResponse.setGender(user.getGender());
		getUserResponse.setStatus(user.getStatus());
		
		return getUserResponse;
	}

}
