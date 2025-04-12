package com.validate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.validate.model.Login;

import jakarta.validation.Valid;

@Controller
public class MainController {

	@GetMapping("/home")
	public String Login(Model m) {
		
		m.addAttribute("login", new Login());
		return "login";
	}
	
	@PostMapping("/submit")
	public String submitFormHandler(@Valid @ModelAttribute ("login") Login login, BindingResult result) {
		
		if (result.hasErrors()) {
			System.out.println(result);
			return "login";
		}
		System.out.println(login);
		return "success";
	}
}