package com.ecomm.beecasual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ecomm.beecasual.service.CategoryService;
import com.ecomm.beecasual.service.ProductService;

@ControllerAdvice("com.ecomm.beecasual")
public class GlobalController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	
	@ModelAttribute
	public void getData(Model model)
	{
		model.addAttribute("categoryListDrop", categoryService.getList());
		
		model.addAttribute("productListAdvice",productService.getJsonProductList());
	}
	
}
