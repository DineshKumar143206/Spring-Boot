package com.SCM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SCM.entity.User;
import com.SCM.msg.Message;
import com.SCM.repository.UserRepository;

import jakarta.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepository;
	
	// Home handler, for the starter page of the application
	@RequestMapping("/")
	public String homeHandler(Model m) {
		
		m.addAttribute("title", "Home - Smart Contact Manager");
		return "home";
	}
	
	// about page 
	@RequestMapping("/about")
	public String aboutHandler(Model m) {
		
		m.addAttribute("title", "About - Smart Contact Manager");
		return "about";
	}
	
	// Register page for Sign up of users 
	@RequestMapping("/register")
	public String registerHandler(Model m) {
		
		m.addAttribute("title", "Register - Smart Contact Manager");
		m.addAttribute("user", new User());
		return "register";
	}
	
	//handling the Register page action
	@PostMapping("/registering_user")
	public String postingRegister(@Valid @ModelAttribute("user") User user, BindingResult valResult,
								  @RequestParam(value = "agreement", defaultValue = "false")boolean agreement,
								  Model m,
								  RedirectAttributes redirectAttributes) {
						
		try {
			
			if (agreement==false ) {
				throw new Exception("Agree to our Terms and Conditions");
			}
			
			if (valResult.hasErrors()) {
				m.addAttribute("user", user);
				return "register";
			}
			
			user.setRole("USER");
			user.setEnabled(true);
			user.setImage("d.png");
			
			userRepository.save(user);
			
			m.addAttribute("user", new User());
			redirectAttributes.addFlashAttribute("message", new Message("Successfully Registered...", "alert-success"));
			return "redirect:/register";
			
			} 

		catch (Exception e) {
			
			e.printStackTrace();
			m.addAttribute("user", user);
			redirectAttributes.addFlashAttribute("message", new Message("Something went Wrong !!! " + e.getMessage(), "alert-danger"));
			return "redirect:/register";
		}
	}
}
