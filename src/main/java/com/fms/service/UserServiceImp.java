package com.fms.service;

import com.fms.dao.UserDao;
import com.fms.dao.UserDaoImp;
import com.fms.entities.User;

public class UserServiceImp implements UserService {

	private UserDao userDao;
	
	
	public UserServiceImp() {
		super();
		userDao = new UserDaoImp();
	}


	@Override
	public User login(String email, String password) {
		return userDao.login(email, password);
	}

}
