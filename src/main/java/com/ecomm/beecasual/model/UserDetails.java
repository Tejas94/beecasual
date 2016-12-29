package com.ecomm.beecasual.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class UserDetails {
	@Id
	private int userId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String contactNo;
	private String userName;
	private String password;
	private int cartId;
	
	
	
	@OneToOne
	@JoinColumn(name="userId", nullable=false, insertable=false, updatable=false)
	private User user;

	
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getContactNo() {
		return contactNo;
	}


	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	@OneToOne
	@JoinColumn(name="cartId", nullable=false, insertable=false, updatable=false)
	private Cart cart;

	@OneToOne
	@JoinColumn(name="billingId" )
	private BillingAddress billingAddress;
	
	@OneToOne
	@JoinColumn(name="shippingId")
	private ShippingAddress shippingAddress ;


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public BillingAddress getBillingAddress() {
		return billingAddress;
	}


	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}


	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}


	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}


	
	
	}
