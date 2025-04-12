package com.thymeleaf.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {

		@RequestMapping(value = "/about", method = RequestMethod.GET)
		public String about(Model m) { 
		
		m.addAttribute("name", "Dinesh kumar");	
		m.addAttribute("datetime", new java.util.Date());
		return "about";
	}
		
		@GetMapping("/loop")
		public String iterateHandler(Model m) {
			
			List<String> names = new ArrayList<>();
			names.add("Dinesh");
			names.add("Manoj");
			names.add("Sam");
			m.addAttribute("names",names);
			return "iterator";
		}
		
		@GetMapping("/fragment")
		public String fragHandler(Model m) {
			m.addAttribute("name", "Dinesh kumar");
			m.addAttribute("date", LocalDateTime.now().toString());
			return "fragment";
		}
		
		@GetMapping("/common")
		public String inheritHandler() {
			
			return"inheriting";
		}
		
		@GetMapping("/common2")
		public String inherit2Handler() {
			
			return"inheriting2";
		}
}
