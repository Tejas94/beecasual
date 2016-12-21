package com.ecomm.beecasual.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Supplier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int supplierId;
	@NotEmpty(message="please enter name")
	@Pattern(regexp="([a-zA-Z]{1})+[a-zA-Z0-9]+" ,message="enter valid name")
	private String supplierName;
	@NotEmpty(message="please enter address")
	private String supplierAddress;
	@NotEmpty(message="please enter Contact")
	@Pattern(regexp="[0-9]+", message="enter valid no.")
	@Size(min=10,max=10, message="enter 10 characters")
    private String supplierContact;
	@NotEmpty(message="please enter emailId")
	@Email(message="enter valid email id")
	private String supplierEmailId;
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	public String getSupplierContact() {
		return supplierContact;
	}
	public void setSupplierContact(String supplierContact) {
		this.supplierContact = supplierContact;
	}
	public String getSupplierEmailId() {
		return supplierEmailId;
	}
	public void setSupplierEmailId(String supplierEmailId) {
		this.supplierEmailId = supplierEmailId;
	}
	
	

}
