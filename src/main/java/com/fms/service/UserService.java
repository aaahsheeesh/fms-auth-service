package com.fms.service;

import com.fms.entities.User;

public interface UserService {

	public abstract User login(String email , String password);
	
	public abstract String logout(int id);

}
