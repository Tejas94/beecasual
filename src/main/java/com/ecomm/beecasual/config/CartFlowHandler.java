package com.ecomm.beecasual.config;

import org.springframework.stereotype.Component;

import com.ecomm.beecasual.model.CartDetails;

@Component
public class CartFlowHandler {
	
	public CartDetails initFlow()
	{
		return new CartDetails();
	}

}
