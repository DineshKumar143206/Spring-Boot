package com.SCM.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.SCM.entity.User;
import com.SCM.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user =  userRepository.getUserByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("no user found !!!");
		}
		
		CustomUserDetails csd = new CustomUserDetails(user);
		
		return csd;
	}

}
