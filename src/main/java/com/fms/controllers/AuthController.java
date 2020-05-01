package com.fms.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fms.entities.User;
import com.fms.service.UserService;
import com.fms.service.UserServiceImp;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

	private UserService userService = new UserServiceImp();

	@PostMapping("/login")
	public User login(@RequestParam(name = "email") Optional<String> email,
			@RequestParam(name = "password") Optional<String> password) {
		
		return userService.login(email.get(), password.get());
	}

}
