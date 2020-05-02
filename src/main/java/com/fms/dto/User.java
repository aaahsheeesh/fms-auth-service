package com.fms.dto;

import javax.validation.constraints.NotEmpty;

public class User {

	private int userId;
	
	@NotEmpty(message = "Please provide a name")
	private String userName;
	
	@NotEmpty(message = "Please provide a password")
	private String userPassword;
	
	@NotEmpty(message = "Please provide a phone")
	private String userPhone;
	
	@NotEmpty(message = "Please provide a email")
	private String email;
	
	@NotEmpty(message = "Please provide a UserType")
	private String userType;
	
	private boolean active;

	public User() {
		super();
	}

	public User(int userId, String userName, String userPassword, String userPhone, String email, String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.email = email;
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPhone=" + userPhone + ", email=" + email
				+ ", userType=" + userType + "]";
	}

}
