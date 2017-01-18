package com.ecomm.beecasual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.beecasual.daoimpl.CartItemDAOImpl;
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
	
	public void updateFlag(int cartItemId)
	{
		cartItemDAOImpl.updateFlag(cartItemId);
	}
	
	public List<CartItem> getCartItemList(int userId)
	{
		return cartItemDAOImpl.getCartItemList(userId);
	}
	
	public void deleteCartItem(int cartItemId)
	{
		cartItemDAOImpl.deleteCartItem(cartItemId);
	}
}
