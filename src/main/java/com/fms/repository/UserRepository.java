package com.fms.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fms.dto.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	Optional<User> findByEmail(String userEmail);
}
