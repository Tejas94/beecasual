package com.ecomm.beecasual.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecomm.beecasual.model.BillingAddress;
import com.ecomm.beecasual.model.ShippingAddress;
import com.ecomm.beecasual.model.UserDetails;
import com.ecomm.beecasual.service.CategoryService;
import com.ecomm.beecasual.service.UserDetailsService;

@Controller
public class UserDetailsController {
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	CategoryService categoryService;
	@RequestMapping("/registerUser")
	public String registerUser(Model model)
	{
		UserDetails userDetails= new UserDetails();
		ShippingAddress shippingAddress= new ShippingAddress();
		BillingAddress billingAddress= new BillingAddress();
		userDetails.setBillingAddress(billingAddress);
		userDetails.setShippingAddress(shippingAddress);
		
		model.addAttribute("userDetails",userDetails);
		model.addAttribute("categoryListDrop", categoryService.getList());
		
		return "/registerUser";
	}
	
	@RequestMapping("/addUser")
	public String addUser(@ModelAttribute("userDetails") UserDetails userDetails)
	{
				userDetailsService.addUserDetails(userDetails);
				return "redirect:/registerUser";
		
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("categoryListDrop", categoryService.getList());
		return "/login";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response)
	{
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth !=null)
		{
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/";
	}


}
