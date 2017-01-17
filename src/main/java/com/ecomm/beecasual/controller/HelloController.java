package com.ecomm.beecasual.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecomm.beecasual.service.CategoryService;
import com.ecomm.beecasual.service.ProductService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class HelloController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	
	@GetMapping("/hello")
	public String hello(Model model) {

		model.addAttribute("name", "tejas p");
		

		return "welcome";
	}
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("categoryListDrop", categoryService.getList());
		model.addAttribute("productViewList", productService.getProductViewList());
		
		
		return "/index";
	}

	
	
}