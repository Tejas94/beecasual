package com.ecomm.beecasual.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello(Model model) {

		model.addAttribute("name", "tejas p");

		return "welcome";
	}
	@RequestMapping("/")
	public String index(Model model) {

		return "/index";
	}

	
	
}