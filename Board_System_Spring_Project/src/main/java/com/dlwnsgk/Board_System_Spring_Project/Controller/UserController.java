package com.dlwnsgk.Board_System_Spring_Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dlwnsgk.Board_System_Spring_Project.entity.Role;
import com.dlwnsgk.Board_System_Spring_Project.entity.User;
import com.dlwnsgk.Board_System_Spring_Project.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public String register(@ModelAttribute User user) { // automatically mapped into User class data
		String userPassword = user.getPassword();
		// System.out.println(userPassword);
		String passwordEncoded = passwordEncoder.encode(userPassword); // encodes password
		user.setPassword(passwordEncoded);
		user.setRole(Role.MEMBER);
		userService.insertUser(user); // added to DB
		
		return "redirect:/loginPage";
	}
	
}
