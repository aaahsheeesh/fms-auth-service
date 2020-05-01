package com.fms.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fms.dto.ResponseTemplate;
import com.fms.dto.User;
import com.fms.exceptions.UserNotFoundException;
import com.fms.service.UserService;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	@ResponseBody
	public ResponseTemplate<User> login(@RequestParam(name = "email") Optional<String> email,
			@RequestParam(name = "password") Optional<String> password) {

		if (!email.isPresent() || email.get().isEmpty()) {
			return new ResponseTemplate<>(false, "EMAIL MISSING", null);
		}else if (!password.isPresent() || password.get().isEmpty()) {
			return new ResponseTemplate<>(false, "PASSWORD MISSING", null);
		} else {
			try {
				return new ResponseTemplate<>(true, "SUCCESS", userService.login(email.get(), password.get()));
			} catch (UserNotFoundException e) {
				return new ResponseTemplate<>(false,e.getMessage(), null);
			}
		}
	}

	@PostMapping("/register")
	public ResponseTemplate<User> register(@RequestBody User user) {
		return new ResponseTemplate<>(true, "SUCCESS", userService.register(user));
	}

	@PostMapping("/logout")
	public ResponseTemplate<?> logout(@RequestParam(name = "id") int id) {
		// TODO: Call Service layer to update user status
		return new ResponseTemplate<>(true, "SUCCESSFULLY LOGGED OUT", null);
	}
}
