package com.ecomm.beecasual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecomm.becasual.service.CategoryService;
import com.ecomm.becasual.service.SubCategoryService;
import com.ecomm.beecasual.model.Category;
import com.ecomm.beecasual.model.SubCategory;

@Controller
public class SubCategoryController {
	@Autowired
	 SubCategoryService subCategoryService;
	@Autowired
	 CategoryService categoryService;
	
	@RequestMapping("/subCategory")
	public String getSubCategory(Model model){
		model.addAttribute("subcategory", new SubCategory());
		model.addAttribute("category",new Category());
		model.addAttribute("categoryList", categoryService.getList());
		model.addAttribute("subCategoryList",subCategoryService.getJsonSubCategoryList());
		return "/subCategory";
	}
	
	
	@RequestMapping("/addSubCategory")
	public String addSubCategory(@ModelAttribute("subCategory") SubCategory subCategory){
	
		Category category=categoryService.getCategoryByName(subCategory.getCategory().getCategoryName());
        
        subCategory.setCategory(category);
        subCategory.setCategoryId(category.getCategoryId());
        subCategoryService.addSubCategory(subCategory);
		return "redirect:/subCategory";
	}
}
