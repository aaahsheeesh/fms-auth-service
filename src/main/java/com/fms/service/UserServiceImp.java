package com.fms.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fms.dao.UserDao;
import com.fms.dao.UserDaoImp;
import com.fms.entities.User;

public class UserServiceImp implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	public UserServiceImp() {
		super();
	}

	@Override
	public User login(String email, String password) {
		return userDao.login(email, password);
	}


	@Override
	public String logout(int id) {
		return userDao.logout(id);
	}
}
