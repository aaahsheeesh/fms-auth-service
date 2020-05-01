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
		userDb.put("gauti@gmail.com", new User(1, "Gautam", "Gautam", "7042312883", "gauti@gmail.com", "ADMIN"));
		userDb.put("akash@gmail.com", new User(2, "Akash", "Akash", "7042312883", "akash@gmail.com", "USER"));
	}

	@Override
	public User login(String email, String password) {
		User user = searchUser(email);
		if (user == null) {
			System.out.println("Username  doesnot exist");
			return null;
		} else if (!user.getUserPassword().equals(password)) {
			System.out.println("Password does not match");
			return null;
		}

		return user;
	}

	private User searchUser(String username) {
		if (userDb.containsKey(username)) {
			return userDb.get(username);
		}
		return null;
	}

}
