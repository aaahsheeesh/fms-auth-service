package com.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fms.dao.UserDao;
import com.fms.dao.UserDaoImp;
import com.fms.service.UserService;
import com.fms.service.UserServiceImp;

@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

	@Bean
	public UserService getUserService() {
		return new UserServiceImp();
	}
	
	@Bean
	public UserDao getUserDao() {
		return new UserDaoImp();
	}
}
