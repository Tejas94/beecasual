package com.ecomm.beecasual.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.ecomm.beecasual.model.BillingAddress;
import com.ecomm.beecasual.model.ShippingAddress;
import com.ecomm.beecasual.model.UserDetails;
import com.ecomm.beecasual.service.UserDetailsService;

@Component
public class RegistrationHandler {
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	ShippingAddress shippingAddress;
	@Autowired
	BillingAddress billingAddress;
	public UserDetails initFlow()
	{
		return new UserDetails();
		
	}
	
    	public String validateUser(UserDetails userDetails,MessageContext messageContext)
    	{
    		String status  = "success";
    		if(userDetails.getFirstName().isEmpty())
    		{
    			messageContext.addMessage(new MessageBuilder().error().source(
    					"firstName").defaultText("firstname cant be empty").build());
    			status="failure";
    		}
    		if(userDetails.getLastName().isEmpty())
    		{
    			messageContext.addMessage(new MessageBuilder().error().source(
    					"lastName").defaultText("lastName cant be empty").build());
    			
    			 status="failure";
    		}
    		if(userDetails.getUserName().isEmpty())
    		{
    			messageContext.addMessage(new MessageBuilder().error().source(
    					"userName").defaultText("userName cant be empty").build());
    			
    			 status="failure";
    		}
    		if(userDetails.getPassword().isEmpty())
    		{
    			messageContext.addMessage(new MessageBuilder().error().source(
    					"password").defaultText("password cant be empty").build());
    			
    			 status="failure";
    		}
    		if(userDetails.getEmailId().isEmpty())
    		{
    			messageContext.addMessage(new MessageBuilder().error().source(
    					"emailId").defaultText("emailId cant be empty").build());
    			
    			 status="failure";
    		}
    		if(userDetails.getContactNo().isEmpty())
    		{
    			messageContext.addMessage(new MessageBuilder().error().source(
    					"contactNo").defaultText("contactNo cant be empty").build());
    			
    			return status="failure";
    		}
    		 return status;
    	}
    	
    	public String validateAddress(ShippingAddress shippingAddress, MessageContext messageContext)
    	{
    		String status="success";
    		if(shippingAddress.getFlatNo().isEmpty())
    		{
    			messageContext.addMessage(new MessageBuilder().error().source(
    					"flatNo").defaultText("flatNo cant be empty").build());
    			status="failure";
    		}
    		if(shippingAddress.getStreet().isEmpty())
    		{
    			messageContext.addMessage(new MessageBuilder().error().source(
    					"street").defaultText("street cant be empty").build());
    			status="failure";
    		}
    		if(shippingAddress.getLocatlity().isEmpty())
    		{
    			messageContext.addMessage(new MessageBuilder().error().source(
    					"locality").defaultText("locality cant be empty").build());
    			status="failure";
    		}
    		if(shippingAddress.getCity().isEmpty())
    		{
    			messageContext.addMessage(new MessageBuilder().error().source(
    					"city").defaultText("city cant be empty").build());
    			status="failure";
    		}
    		if(shippingAddress.getState().isEmpty())
    		{
    			messageContext.addMessage(new MessageBuilder().error().source(
    					"state").defaultText("state cant be empty").build());
    			status="failure";
    		}
    		if(shippingAddress.getPincode().isEmpty())
    		{
    			messageContext.addMessage(new MessageBuilder().error().source(
    					"pincode").defaultText("pincode cant be empty").build());
    			status="failure";
    		}
    		
    		
    		return status;
    	}
    	
    	public String checkUser(UserDetails userDetails,MessageContext messageContext)
    	{
    		String status="success";
    	
    		return status;
    	}
    	
    	
    	public void addShippingAddress(ShippingAddress shippingAddress)
    	{
    		this.shippingAddress.setFlatNo(shippingAddress.getFlatNo());
    		this.shippingAddress.setStreet(shippingAddress.getStreet());
    		this.shippingAddress.setLocatlity(shippingAddress.getLocatlity());
    		this.shippingAddress.setCity(shippingAddress.getCity());
    		this.shippingAddress.setState(shippingAddress.getState());
    		this.shippingAddress.setPincode(shippingAddress.getPincode());
    		
    	}
    	
    	public void addBillingAddress(BillingAddress billingAddress)
    	{
    		this.billingAddress.setFlatNo(billingAddress.getFlatNo());
    		this.billingAddress.setStreet(billingAddress.getStreet());
    		this.billingAddress.setLocatlity(billingAddress.getLocatlity());
    		this.billingAddress.setCity(billingAddress.getCity());
    		this.billingAddress.setState(billingAddress.getState());
    		this.billingAddress.setPincode(billingAddress.getPincode());
    		
    	}
    	
    	
    	public String addRegUser(UserDetails userDetails,BillingAddress billingAddress, ShippingAddress shippingAddress)
    	{
    		
    		userDetailsService.addRegUserDetails(userDetails);
    		shippingAddress.setUserDetails(userDetails);
    		userDetails.setShippingAddress(shippingAddress);
    		this.shippingAddress.setUserDetails(userDetails);
    		
    		billingAddress.setUserDetails(userDetails);
    		userDetails.setBillingAddress(billingAddress);
    		this.billingAddress.setUserDetails(userDetails);
    		
    		
    		userDetails.setShippingAddress(shippingAddress);
    		userDetails.setBillingAddress(billingAddress);
    		
    		userDetailsService.addShippingAddress(shippingAddress);
    		userDetailsService.addBillingAddress(billingAddress);
    		
    		userDetailsService.addRegUserDetails(userDetails);
    		return "success";
    		
    		
    	}
}
