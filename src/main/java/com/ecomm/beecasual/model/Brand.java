package com.ecomm.beecasual.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Brand implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int brandId;
	@NotEmpty(message="please enter name")
	private String brandName;
	@NotEmpty(message="please enter description")
	private String brandDescription;
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getBrandDescription() {
		return brandDescription;
	}
	public void setBrandDescription(String brandDescription) {
		this.brandDescription = brandDescription;
	}
	

}
