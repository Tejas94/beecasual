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
import com.ecomm.becasual.service.SupplierService;

import com.ecomm.beecasual.model.Supplier;

@Controller
public class SupplierController {
	
	@RequestMapping("/supplier")
	public String category(Model model)
	{
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("supplierList",supplierService.getJsonSupplierList());
		model.addAttribute("categoryListDrop", categoryService.getList());
		return "/supplier";
	}
	@Autowired
	SupplierService supplierService;
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping("/addSupplier")
	public String addSupplier(Model model, @Valid @ModelAttribute("supplier") Supplier supplier,BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			model.addAttribute("supplierList",supplierService.getJsonSupplierList());
		
			return "/supplier";
		}
		else
		{
		supplierService.addSupplier(supplier);
		return "redirect:/supplier";
		}
	}
	@RequestMapping("/deleteSupplier-{supplierId}")
	public String deleteSupplier(@PathVariable("supplierId")  int supplierId)
	{
		supplierService.deleteSupplier(supplierId);
		return "redirect:/supplier";
	}
	@RequestMapping("/editSupplier-{supplierId}")
	public String editSupplier(Model model,@PathVariable("supplierId") int supplierId){
		
		model.addAttribute("supplier", supplierService.getSupplierById(supplierId));
		
		
		return "/supplier";
		
	}
	

}
