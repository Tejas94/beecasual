package com.ecomm.beecasual.controller;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.beecasual.model.WishList;
import com.ecomm.beecasual.service.CartItemService;
import com.ecomm.beecasual.service.ProductService;
import com.ecomm.beecasual.service.UserDetailsService;
import com.ecomm.beecasual.service.WishListService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class WishListController {

	@Autowired
	WishListService wishListService;
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	ProductService productService;
	
	
	@RequestMapping("/wishList-{productId}")	
	public String getWishListControl(@PathVariable("productId") int productId,WishList wishList,HttpSession session,@RequestParam("userId") int userId,Model model)
	{
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String userName=authentication.getName();
		userDetailsService.getUserByName(userName);
		userId=userDetailsService.getUserByName(userName).getUserId();
		wishList.setCartId(userId);
		wishList.setUserId(userId);
		wishList.setFlag(false);
		
		wishList.setProductId(productId);
		double price=productService.getProductListById(productId).getProductPrice();
		String productName=productService.getProductListById(productId).getProductName();
		wishList.setProductName(productName);
		wishList.setProductPrice(price);
		
		wishListService.addWishList(wishList);
		
		
		
		
		
		return "redirect:/wishList";
	}
	
	@RequestMapping("/wishList")
	public String showWish(HttpSession session,Model model )
	{
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String userName=authentication.getName();
		userDetailsService.getUserByName(userName);
		int userId=userDetailsService.getUserByName(userName).getUserId();
		session.setAttribute("userId", userId);
		
		
		
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String viewWish=gson.toJson(wishListService.getWishList(userId));
		model.addAttribute("wishJson", viewWish);
		
		return "/wishList";
		
		
	}
	
	@RequestMapping("/deleteWishList-{wishListId}")
	public String deletWish(@PathVariable("wishListId")int wishListId)
	{
		wishListService.deleteWhish(wishListId);
		return "redirect:/wishList";
	}
	
}
