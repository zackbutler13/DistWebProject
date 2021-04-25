package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//Home page 
@Controller	
public class HomeController {
	
	//controller for home page
	@RequestMapping("/home")
	public String test() {
		return "home";
	}

}