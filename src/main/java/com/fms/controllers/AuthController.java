package com.fms.controllers;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fms.dto.ResponseDTO;
import com.fms.dto.User;
import com.fms.exceptions.UserNotFoundException;
import com.fms.service.UserService;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseDTO<User> login(@RequestParam(name = "email") Optional<String> email,
			@RequestParam(name = "password") Optional<String> password) throws UserNotFoundException{

		if (!email.isPresent() || email.get().isEmpty()) {
			return new ResponseDTO<>(false, "Email Missing", null);
		}else if (!password.isPresent() || password.get().isEmpty()) {
			return new ResponseDTO<>(false, "Password Missing", null);
		} else {
			try {
				return new ResponseDTO<>(true, "Success", userService.login(email.get(), password.get()));
			} catch (UserNotFoundException e) {
				//throw new UserNotFoundException("User not found");
				return new ResponseDTO<>(false,e.getMessage(), null);
			}
		}
	
	}

	@PostMapping("/register")
	public ResponseDTO<User> register(@Valid @RequestBody User user) {
		return new ResponseDTO<>(true, "Success", userService.register(user));
	}

	@PostMapping("/logout/{id}")
	public ResponseDTO<Object> logout(@PathVariable(name = "id")int id) {
		// TODO: Call Service layer to update user status
		return new ResponseDTO<>(true, "Sucessfully logged out", null);
	}
}
