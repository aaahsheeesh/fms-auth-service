package com.fms.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Validation;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fms.dto.BaseResponse;
import com.fms.dto.User;
import com.fms.exceptions.UserNotFoundException;
import com.fms.service.UserService;
import com.fms.utils.ValidationUtil;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	@ResponseBody
	public BaseResponse<User> login(@RequestParam(name = "email") Optional<String> email,
			@RequestParam(name = "password") Optional<String> password) {

		if (!email.isPresent() || email.get().isEmpty()) {
			return new BaseResponse<>(false, "EMAIL MISSING", null);
		} else if (!ValidationUtil.validateEmail(email.get())) {
			return new BaseResponse<>(false, "INCORRECT EMAIL", null);
		} else if (!password.isPresent() || password.get().isEmpty()) {
			return new BaseResponse<>(false, "PASSWORD MISSING", null);
		} else if (!ValidationUtil.validatePassword(password.get())) {
			return new BaseResponse<>(false, "PASSWORD LENGTH SHOULD BE MORE THAN 8 CHARCTERS", null);
		} else {
			try {
				return new BaseResponse<>(true, "SUCCESS", userService.login(email.get(), password.get()));
			} catch (UserNotFoundException e) {
				return new BaseResponse<>(false,e.getMessage(), null);
			}
		}
	}

	@PostMapping("/logout")
	public BaseResponse<Object> logout(@RequestParam(name = "id") int id) {
		// TODO: Call Service layer to update user status
		return new BaseResponse<>(true, "SUCCESSFULLY LOGGED OUT", null);
	}
}
