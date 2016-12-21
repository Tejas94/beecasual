package com.ecomm.beecasual.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ProductSpecification {
	
	@Id
	private int productId;
	private String color;
	private String fabric;
	private String pattern;
	private String fit;
	private String washcare;
	
	@OneToOne
	@JoinColumn(name="productId", nullable=false,updatable=false, insertable=false)
	private Product product;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getFit() {
		return fit;
	}

	public void setFit(String fit) {
		this.fit = fit;
	}

	public String getWashcare() {
		return washcare;
	}

	public void setWashcare(String washcare) {
		this.washcare = washcare;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
