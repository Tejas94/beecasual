package com.ecomm.beecasual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ecomm.beecasual.service.CategoryService;

@ControllerAdvice("com.ecomm.beecasual")
public class GlobalController {

	@Autowired
	CategoryService categoryService;
	
	@ModelAttribute
	public void getData(Model model)
	{
		model.addAttribute("categoryListDrop", categoryService.getList());
		model.addAttribute("categoryListAdvice", categoryService.getJsonList());
	}
	
}
