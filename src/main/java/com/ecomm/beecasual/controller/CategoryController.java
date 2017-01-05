package com.ecomm.beecasual.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecomm.becasual.service.CategoryService;
import com.ecomm.beecasual.model.Category;

@Controller
public class CategoryController 
{
	
	@RequestMapping("/category")
	public String category(Model model)
	{
		model.addAttribute("category", new Category());
		model.addAttribute("categoryList", categoryService.getJsonList());
		model.addAttribute("categoryListDrop", categoryService.getList());
		return "/category";
	}
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/addCategory")
	public String addCategory(@Valid@ModelAttribute("category") Category category,BindingResult bindingResult,Model model)
	{
		if(bindingResult.hasErrors()){
			model.addAttribute("categoryList", categoryService.getJsonList());
			return "/category";
			
		}
		else
		{
		categoryService.addCategory(category);
		return "redirect:/category";
		}
	}
	@RequestMapping("/deleteCategory-{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")  int categoryId)
	{
		categoryService.deleteCategory(categoryId);
		return "redirect:/category";
	}
	@RequestMapping("/editCategory-{categoryId}")
	public String editCategory(Model model,@PathVariable("categoryId") int categoryId){
		
		model.addAttribute("category", categoryService.getListById(categoryId));
		
		
		return "/category";
		
	}
	
}
