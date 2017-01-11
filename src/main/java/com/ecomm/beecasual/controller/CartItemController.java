package com.ecomm.beecasual.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.becasual.service.CartItemService;
import com.ecomm.becasual.service.ProductService;
import com.ecomm.becasual.service.UserDetailsService;
import com.ecomm.beecasual.model.CartItem;
import com.ecomm.beecasual.model.Product;
import com.ecomm.beecasual.model.UserDetails;

@Controller
public class CartItemController {
	@Autowired
	CartItemService cartItemService;
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	ProductService productService;
	
	@RequestMapping("/buyNow-{productId}")
	public String buyNow(Model model,@PathVariable("productId") int productId,@ModelAttribute("cartItem") CartItem cartItem,@RequestParam("userId") int userId,Product product,HttpSession session)
	{
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String userName=authentication.getName();
		userDetailsService.getUserByName(userName);
		userId=userDetailsService.getUserByName(userName).getUserId();
		cartItem.setCartId(userId);
		cartItem.setUserId(userId);
		cartItem.setFlag(false);
		cartItem.setProductQuantity(1);
		cartItem.setProductId(productId);
		double price=productService.getProductListById(productId).getProductPrice();
		String productName=productService.getProductListById(productId).getProductName();
		cartItem.setProductName(productName);
		cartItem.setProductPrice(price);
		
		cartItemService.addCartItem(cartItem);
		
		
		productService.updateQuantity(productId);
		
		
		return "redirect:/cartList";
	}
	
	
}
