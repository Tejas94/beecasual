package com.ecomm.beecasual.config;

import org.springframework.stereotype.Component;

import com.ecomm.beecasual.model.UserDetails;

@Component
public class RegistrationHandler {
	public UserDetails initFlow()
	{
		return new UserDetails();
		
	}
	

}
