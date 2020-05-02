package com.fms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fms.dto.UserDTO;
import com.fms.entities.User;
import com.fms.exceptions.UserNotFoundException;
import com.fms.repository.UserRepository;

public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;

	public UserServiceImp() {
		super();
	}

	@Override
	public User login(String email, String password) throws UserNotFoundException {
		Optional<User> user = userRepository.findByEmail(email);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User not found");
		} else if (!user.get().getUserPassword().equals(password)) {
			return null;
		} else {
			user.get().setActive(true);
			userRepository.save(user.get());
			return user.get();
		}
	}

	@Override
	public User register(UserDTO userDTO) {
		User user = new User();
		user.setUserName(userDTO.getUserName());
		user.setUserPassword(userDTO.getUserPassword());
		user.setEmail(userDTO.getEmail());
		user.setUserPhone(userDTO.getUserPhone());
		user.setUserType(userDTO.getUserType());
		return userRepository.save(user);
	}

	@Override
	public User logout(int id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User not found");
		} else {
			user.get().setActive(false);
			return userRepository.save(user.get());
		}
	}
}
