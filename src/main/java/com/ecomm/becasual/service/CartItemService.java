package com.ecomm.becasual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.becasual.daoimpl.CartItemDAOImpl;
import com.ecomm.beecasual.model.CartItem;

@Service
@Transactional
public class CartItemService {
	@Autowired	
	CartItemDAOImpl  cartItemDAOImpl;
	
	public void addCartItem(CartItem cartItem){
		cartItemDAOImpl.addCartItem(cartItem);
	}
	
	public CartItem getCartItemListById(int cartItemId )
	{
		return cartItemDAOImpl.getCartItemListById(cartItemId);
	}
	
}
