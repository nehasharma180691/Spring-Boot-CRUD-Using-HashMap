package com.boot.jpa.dtos;

import java.util.Date;

import com.boot.jpa.model.Gender;
import com.boot.jpa.model.User;

public class UserUpdateRequest {
	
	private String name;
	private String email;
	private Integer age;
	private Gender gender;
	private Date updatedOn;
	
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
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public User DtoToModel() {
		User user = new User();
		user.setName(this.getName());
		user.setEmail(this.getEmail());		
		
		user.setAge(this.getAge());
		user.setGender(this.getGender());
		user.setCreatedOn(new Date());
		
		return user;
	}
	
}
