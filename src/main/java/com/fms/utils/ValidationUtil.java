package com.fms.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

	/**
	 * @param String
	 * @return
	 * 
	 * Method to validate email using regular expression
	 */
	public static boolean validateEmail(String email) {
		String emailRegex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);
		if (email.isEmpty() || !matcher.matches()) {
			return false;
		}
		return true;
	}

	
	/**
	 * @param String
	 * @param String
	 * @param boolean
	 * @return
	 * 
	 * Method to validate password. Password should contain 
	 * 8 letters with 1 uppercase,1 lowercase, 1 number, and 1 special characer
	 */
	public static boolean validatePassword(String password) {
		if (password.isEmpty() || password.length() < 8) {
			return false;
		} 
		return true;
	}
}
