package com.jpa;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.model.User;
import com.jpa.repo.UserRepository;

@SpringBootApplication
public class BootJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(BootJpaApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		User user = new User();
		user.setName("Sam");
		user.setCity("dubai");
		user.setStatus("invoice creator");
		
		User user2 = userRepository.save(user);
		System.out.println(user2);
		
		List<User> users = userRepository.findByName("Manoj");
		for (User ellaro : users) {
			System.out.println(ellaro);
		}
	}
}
