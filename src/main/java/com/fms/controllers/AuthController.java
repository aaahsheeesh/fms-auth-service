package com.fms.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fms.entities.BaseResponse;
import com.fms.entities.User;
import com.fms.service.UserService;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public BaseResponse<User> login(@RequestParam(name = "email") Optional<String> email,
			@RequestParam(name = "password") Optional<String> password) {

		if (!email.isPresent() || email.get().isEmpty()) {
			return new BaseResponse<>(false, "EMAIL MISSING", null);
		} else if (!password.isPresent() || password.get().isEmpty()) {
			return new BaseResponse<>(false, "PASSWORD MISSING", null);
		} else {
			User user = userService.login(email.get(), password.get());
			if (user == null) {
				return new BaseResponse<>(false, "NO SUCH USER PRESENT", null);
			} else {
				return new BaseResponse<>(true, "SUCCESS", user);
			}
		}
	}

}
