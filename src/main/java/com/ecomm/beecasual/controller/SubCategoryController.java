package com.ecomm.beecasual.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecomm.beecasual.model.Category;
import com.ecomm.beecasual.model.SubCategory;
import com.ecomm.beecasual.service.CategoryService;
import com.ecomm.beecasual.service.SubCategoryService;

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
		model.addAttribute("categoryListDrop", categoryService.getList());
		return "/subCategory";
	}
	
	
	@RequestMapping("/addSubCategory")
	public String addSubCategory(@Valid@ModelAttribute("subCategory") SubCategory subCategory, BindingResult bindingresult, Model model)
	{
		if(bindingresult.hasErrors())
		{
			
			return "/subCategory";
		}
		else
		{
		Category category=categoryService.getCategoryByName(subCategory.getCategory().getCategoryName());
        
        subCategory.setCategory(category);
        subCategory.setCategoryId(category.getCategoryId());
        subCategoryService.addSubCategory(subCategory);
		return "redirect:/subCategory";
		}
	}
	@RequestMapping("/editSubCategory-{subcategoryId}")
	public String editProduct(Model model,@PathVariable("subcategoryId") int subcategoryId){
	
	model.addAttribute("categoryList", categoryService.getList());
	model.addAttribute("subcategory", subCategoryService.getSubCategoryListById(subcategoryId));
	
	
	return "/subCategory";

}
	@RequestMapping("/deleteSubCategory-{subcategoryId}")
	public String deleteProduct(@PathVariable("subcategoryId") int subcategoryId)
	{
	subCategoryService.deleteSubCategory(subcategoryId);
	return "redirect:/subCategory";
	}

}
