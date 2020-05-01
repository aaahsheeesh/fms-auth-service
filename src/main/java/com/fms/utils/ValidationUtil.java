package com.fms.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fms.dto.ValidationError;

public class ValidationUtil {

	private static String message;

	public static ValidationError loginValidation(String email, String password) {

		return (!validateEmail(email) && !validatePassword(password)) ? new ValidationError(false, message)
				: new ValidationError(true);
	}

	/**
	 * @param String
	 * @return
	 * 
	 *         Method to validate email using regular expression
	 */
	public static boolean validateEmail(String email) {
		String emailRegex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);
		if (email.isEmpty()) {
			message = "Email missing";
			return false;
		} else if (!matcher.matches()) {
			message = "Incorrect Email";
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
	 *         Method to validate password. Password should be 8 characters long.
	 * 
	 */
	public static boolean validatePassword(String password) {
		if (password.isEmpty()) {
			message = "Password cannot be empty";
			return false;
		} else if (password.length() < 8) {
			message = "Password must contain atleast 8 characters";
			return false;
		}
		return true;
	}
}
