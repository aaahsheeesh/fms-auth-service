package com.fms.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class User {

	private int userId;

	@NotEmpty(message = "Name cannot be blank")
	private String userName;

	@NotEmpty(message = "Password cannot be blank")
	private String userPassword;

	@NotEmpty(message = "Phone cannot be blank")
	@Pattern(regexp = "^[1-9][0-9]{9}$", 
		message = "Invalid phone number should be 10digit and must not start with 0")
	private String userPhone;

	@NotEmpty(message = "Email cannot be blank")
	@Email(message = "Invalid email")
	private String email;

	@NotEmpty(message = "User type cannot be blank")
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
