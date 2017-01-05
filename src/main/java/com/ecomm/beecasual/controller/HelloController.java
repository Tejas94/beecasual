package com.ecomm.beecasual.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecomm.becasual.service.CategoryService;

@Controller
public class HelloController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/hello")
	public String hello(Model model) {

		model.addAttribute("name", "tejas p");
		

		return "welcome";
	}
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("categoryListDrop", categoryService.getList());
		return "/index";
	}

	
	
}