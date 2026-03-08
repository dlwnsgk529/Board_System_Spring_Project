package com.dlwnsgk.Board_System_Spring_Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dlwnsgk.Board_System_Spring_Project.entity.User;
import com.dlwnsgk.Board_System_Spring_Project.mapper.UserMapper;

@Service
public class UserService {
	
	// Dependency Injection
	@Autowired
	private UserMapper userMapper;
	
	public void insertUser(User user) {
		userMapper.insertUser(user); // automatically inserts data to DB @ UserMapper.java
	}
	
	public User findByUsername(String username) {
		return userMapper.findByUsername(username);
	}
	
	
	public String findWriter(String username) {
		return userMapper.findWriter(username);
	}
	
}
