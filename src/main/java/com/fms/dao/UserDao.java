package com.fms.dao;

import com.fms.dto.User;
import com.fms.exceptions.UserNotFoundException;

public interface UserDao {

	public abstract User login(String email , String password) throws UserNotFoundException;
	
	public abstract String logout(int id);
	
}
