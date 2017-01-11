package com.ecomm.becasual.dao;

import com.ecomm.beecasual.model.BillingAddress;
import com.ecomm.beecasual.model.ShippingAddress;
import com.ecomm.beecasual.model.UserDetails;

public interface UserDetailsDAO {
	
	public void addUserDetails(UserDetails userDetails);
	
	public UserDetails getUserByName(String userName);
	
	public void addRegUserDetails(UserDetails userDetails);
  
	public void addShippingAddress(ShippingAddress shippingAddress);
	
	public void addBillingAddress(BillingAddress billingAddress);
}
