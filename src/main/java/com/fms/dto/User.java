package com.fms.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;
	
	@NotEmpty(message = "Name cannot be blank")
	@Column(name = "user_name")
	private String userName;

	@NotEmpty(message = "Password cannot be blank")
	@Column(name = "user_password")
	private String userPassword;

	@NotEmpty(message = "Phone cannot be blank")
	@Pattern(regexp = "^[1-9][0-9]{9}$", message = "Invalid phone number should be 10digit and must not start with 0")
	@Column(name = "user_phone")
	private String userPhone;

	@NotEmpty(message = "Email cannot be blank")
	@Email(message = "Invalid email")
	@Column(name = "user_email")
	private String email;

	@NotEmpty(message = "User type cannot be blank")
	@Column(name = "user_type")
	private String userType;

	@Column(name = "user_state")
	private boolean active;

	public User() {
		super();
	}

	public User(String userName, String userPassword, String userPhone, String email, String userType) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.email = email;
		this.userType = userType;
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
		return "User [userName=" + userName + ", userPhone=" + userPhone + ", email=" + email
				+ ", userType=" + userType + "]";
	}

}
