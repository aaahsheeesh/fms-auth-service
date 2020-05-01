package com.fms.dao;

import com.fms.entities.User;

public interface UserDao {

	public abstract User login(String email , String password);
}
