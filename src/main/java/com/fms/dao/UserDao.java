package com.fms.dao;

import com.fms.entities.User;

public interface UserDao {

	public abstract User login(String email , String password);
	
	public abstract String logout(int id);
	
}
