package com.SBUP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SBUP.model.User;
import com.SBUP.repository.UserRepository;

@RestController
@RequestMapping("/home")
public class MainController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/allusers")
	public @ResponseBody Iterable<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping("/add")
	public @ResponseBody User addUser(@RequestParam String username,
										@RequestParam String email) {
		
		User u = new User();
		u.setUsername(username);
		u.setEmail(email);
		userRepository.save(u);
		return u;
	}
	
}
