package com.dlwnsgk.Board_System_Spring_Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dlwnsgk.Board_System_Spring_Project.entity.CustomUser;
import com.dlwnsgk.Board_System_Spring_Project.entity.User;
import com.dlwnsgk.Board_System_Spring_Project.mapper.UserMapper;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private UserMapper userMapper;
	@Autowired
	public UserDetailsServiceImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // Model supported by Spring Security
		
		User user = userMapper.findByUsername(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username + " Does not exist.");
		}
		
		return new CustomUser(user);
	}
}
