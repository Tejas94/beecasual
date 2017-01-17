package com.ecomm.beecasual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.beecasual.daoimpl.UserDetailsDAOImpl;
import com.ecomm.beecasual.model.BillingAddress;
import com.ecomm.beecasual.model.ShippingAddress;
import com.ecomm.beecasual.model.UserDetails;

@Service
@Transactional
public class UserDetailsService {

	@Autowired
	UserDetailsDAOImpl userDetailsDAOImpl;
	
	public void addUserDetails(UserDetails userDetails)
	{
		userDetailsDAOImpl.addUserDetails(userDetails);
	}
	
	public UserDetails getUserByName(String userName){
		
		return userDetailsDAOImpl.getUserByName(userName);
	}
	
	public void addRegUserDetails(UserDetails userDetails)
	{
		userDetailsDAOImpl.addRegUserDetails(userDetails);
	}
	
	public void addShippingAddress(ShippingAddress shippingAddress)
	{
		userDetailsDAOImpl.addShippingAddress(shippingAddress);
	};
	
	public void addBillingAddress(BillingAddress billingAddress)
	
	{
		userDetailsDAOImpl.addBillingAddress(billingAddress);
	};
	
	public ShippingAddress getShippingListById(int userId)
	{
		return userDetailsDAOImpl.getShippingListById(userId);

	}
	
	public BillingAddress getBillingListById(int userId)
	{
		
		return userDetailsDAOImpl.getBillingListById(userId);
	}
}

