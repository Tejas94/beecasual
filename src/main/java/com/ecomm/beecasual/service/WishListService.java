package com.ecomm.beecasual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.beecasual.daoimpl.WishListDAOImpl;
import com.ecomm.beecasual.model.WishList;

@Service
@Transactional
public class WishListService {

	@Autowired
	WishListDAOImpl wishListDAOImpl;
	
	public void addWishList(WishList wishList)
	{
		wishListDAOImpl.addWishList(wishList);
	}
	
	public List<WishList> getWishList(int userId)
	{
		return wishListDAOImpl.getWishList(userId);
	}
	public void deleteWhish(int wishListId)
	{
		wishListDAOImpl.deleteWhish(wishListId);
	}
}

