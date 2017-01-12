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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.becasual.service.CartItemService;
import com.ecomm.becasual.service.ProductService;
import com.ecomm.becasual.service.UserDetailsService;
import com.ecomm.beecasual.model.CartItem;
import com.ecomm.beecasual.model.Product;
import com.ecomm.beecasual.model.UserDetails;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
		
		session.setAttribute("cartItemId", cartItem.getCartItemId());
		int cartItemId=(Integer) session.getAttribute("cartItemId");
		System.out.println("id is "+cartItemId);
		return "redirect:/cart-"+cartItemId;
		
	}
	
	
	@RequestMapping("/cart-{cartItemId}")
	public String cartList(HttpSession session,Model model)
	{
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String userName=authentication.getName();
		int userId=userDetailsService.getUserByName(userName).getUserId();
		
		session.setAttribute("userId", userId);
	    int cartItemId=(Integer) session.getAttribute("cartItemId");
		
	    Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String cartList=gson.toJson(cartItemService.getCartItemListById(cartItemId));
		model.addAttribute("clist",cartList);
	
		
		return "/cartList";
	}
	@RequestMapping("/checkout")
	public String checkout(HttpSession session)
	{
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String userName=authentication.getName();
		int userId=userDetailsService.getUserByName(userName).getUserId();
		session.setAttribute("userId", userId);
		return "";
	}
}
