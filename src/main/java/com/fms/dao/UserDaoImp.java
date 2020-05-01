package com.fms.dao;

import java.util.HashMap;
import java.util.Map;

import com.fms.entities.User;

public class UserDaoImp implements UserDao {

	private static Map<String, User> userDb = new HashMap<>();

	public UserDaoImp() {
		super();
		setUserMap();
	}

	public void setUserMap() {
		userDb.put("gauti@gmail.com", new User(1, "Gautam", "password@123", "7042312883", "gauti@gmail.com", "ADMIN"));
		userDb.put("akash@gmail.com", new User(2, "Akash", "password@123", "7042312883", "akash@gmail.com", "USER"));
	}

	@Override
	public User login(String email, String password) {
		User user = searchUser(email);
		if (user == null) {
			return null;
		} else if (!user.getUserPassword().equals(password)) {
			return null;
		}
		user.setActive(true);
		return user;
	}
	
	

	@Override
	public String logout(int id) {
		//TODO: Change active status of user in db
		return null;
	}

	private User searchUser(String username) {
		if (userDb.containsKey(username)) {
			return userDb.get(username);
		}
		return null;
	}

}
