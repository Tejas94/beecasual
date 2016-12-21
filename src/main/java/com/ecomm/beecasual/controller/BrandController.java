package com.ecomm.beecasual.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecomm.becasual.service.BrandService;
import com.ecomm.beecasual.model.Brand;


@Controller
public class BrandController {
	
	@RequestMapping("/brand")
	public String category(Model model)
	{
		model.addAttribute("brand", new Brand());
		model.addAttribute("brandList", brandService.getJsonBrandList());
		return "/brand";
	}
	
	@Autowired
	BrandService brandService;
	
	@RequestMapping("/addBrand")
	public String addBrand(Model model,@Valid @ModelAttribute("brand") Brand brand,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			//model.addAttribute("brand", new Brand());
			model.addAttribute("brandList", brandService.getJsonBrandList());
			
			return "/brand";
		}
		else
		{
		brandService.addBrand(brand);
		return "redirect:/brand";
		}
	}
	@RequestMapping("/deleteBrand-{brandId}")
	public String deleteBrand(@PathVariable("brandId")  int brandId)
	{
		brandService.deleteBrand(brandId);
		return "redirect:/brand";
	}
	@RequestMapping("/editBrand-{brandId}")
	public String editBrand(Model model,@PathVariable("brandId") int brandId){
		
		model.addAttribute("brand", brandService.getBrandListById(brandId));
		
		
		return "/brand";
		
	}


}
