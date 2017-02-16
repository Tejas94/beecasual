package com.ecomm.beecasual.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.beecasual.model.CartItem;
import com.ecomm.beecasual.model.Product;
import com.ecomm.beecasual.model.UserDetails;
import com.ecomm.beecasual.service.CartItemService;
import com.ecomm.beecasual.service.ProductService;
import com.ecomm.beecasual.service.UserDetailsService;
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
		
		
		productService.updateQuantity(productId,cartItem.getProductQuantity());
		
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
	public String checkout(HttpSession session,@RequestParam("userId")int userId)
	{
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String userName=authentication.getName();
		userId=userDetailsService.getUserByName(userName).getUserId();
		session.setAttribute("userId", userId);
		return "redirect:/cart?userId="+userId;
	}
	@RequestMapping("/addCart-{productId}")
	public String addCart(@Valid@ModelAttribute("cartItems") CartItem cartItem,BindingResult bindingResult,Model model,@RequestParam("userId") int userId,@PathVariable("productId") int productId,Product product,HttpSession session)
	{
		if(bindingResult.hasErrors()){
			Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String viewlist= gson.toJson(productService.getProductViewListById(productId));
			model.addAttribute("product",viewlist);
			return "/viewproduct";
		}
		else
		{
		
		
		int cartItemId;
		int count=cartItemService.getCartOnce(productId,cartItem.getProductSize(),userId);
		if(count==1)
		{
			cartItemId = cartItemService.getCartOnceName(productId, cartItem.getProductSize(), userId).getCartItemId();
			productService.updateQuantity1(productId, cartItem.getProductQuantity());
			
		}
		else
		{
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String userName=authentication.getName();
		userDetailsService.getUserByName(userName);
		userId=userDetailsService.getUserByName(userName).getUserId();
		cartItem.setCartId(userId);
		cartItem.setUserId(userId);
		cartItem.setFlag(false);
		if(cartItem.getProductQuantity()==0)
		{
			cartItem.setProductQuantity(1);
		}
		cartItem.setProductId(productId);
		double price=productService.getProductListById(productId).getProductPrice();
		String productName=productService.getProductListById(productId).getProductName();
		cartItem.setProductName(productName);
		cartItem.setProductPrice(price);
		
		cartItemService.addCartItem(cartItem);
		
		productService.updateQuantity(productId,cartItem.getProductQuantity());
		cartItemId = cartItem.getCartItemId();
		}
		
		
		session.setAttribute("cartItemId", cartItemId);
		
		
		return "redirect:/cartItems";
	}
	}
	
	
	@RequestMapping("/cartItems")
	public String showCart(HttpSession session,Model model)
	{
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String userName=authentication.getName();
		int userId=userDetailsService.getUserByName(userName).getUserId();
		
		session.setAttribute("userId", userId);
	   
		
	    Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String showCartList=gson.toJson(cartItemService.getCartItemList(userId));
		model.addAttribute("slist",showCartList);
	
		
		return "/cartItems";
	}
	
	@RequestMapping("/deleteCartItem-{cartItemId}")
	public String deleteCartItem(@PathVariable("cartItemId")  int cartItemId)
	{
		cartItemService.deleteCartItem(cartItemId);
		return "redirect:/cartItems";
	}
}
