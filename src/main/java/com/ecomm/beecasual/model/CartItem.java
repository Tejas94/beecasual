package com.ecomm.beecasual.model;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.google.gson.annotations.Expose;

@Entity
public class CartItem implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Expose
	private int cartItemId;
	@Expose
	private int userId;
	@Expose
	private int cartId;
	@Expose
	private int productId;
	@Expose
	private String productName;
	@Expose
	private double productPrice;
	@Expose
	private int productQuantity;
	@Expose
	private boolean flag;
	
	@Expose
	@ManyToOne
	@JoinColumn(name="cartId",nullable=false,insertable=false,updatable=false)
	private Cart cart;
	@Expose
	@ManyToOne
	@JoinColumn(name="productId",nullable=false,insertable=false,updatable=false)
	private Product product;
	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
