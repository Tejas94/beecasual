package com.ecomm.becasual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.becasual.daoimpl.UserDetailsDAOImpl;
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
	
	public int getUserByName(String userName){
		
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
	
}
