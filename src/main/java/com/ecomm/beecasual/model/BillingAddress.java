package com.ecomm.beecasual.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class BillingAddress implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int billingId;
	private String flatNo;
	private String street;
	private String locatlity;
	private String city;
	private String state;
	private String pincode;
	@OneToOne
	private UserDetails userDetails;
	
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public int getBillingId() {
		return billingId;
	}
	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}
	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLocatlity() {
		return locatlity;
	}
	public void setLocatlity(String locatlity) {
		this.locatlity = locatlity;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
}
