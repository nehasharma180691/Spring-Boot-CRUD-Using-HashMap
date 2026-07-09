package com.boot.jpa.repository;

import java.util.HashMap;
import java.util.Random;

import com.boot.jpa.model.User;

public class UserRepository {
	
	HashMap<Integer, User> map = new HashMap<>();

	public User createUser(User user) {
		user.setId(new Random().nextInt(100));
		map.put(user.getId(), user);
		
		return user;
	}

	public User getUser(Integer id) {		
		if(!map.containsKey(id))
			return null;
		else
			return map.get(id);
	}
	
	public User updateUser(User user) {		
		map.put(user.getId(), user);		
		return user;
	}

	public User deleteUser(Integer id, User existingUser) {
		return map.put(id, existingUser);		
	}

	
}
