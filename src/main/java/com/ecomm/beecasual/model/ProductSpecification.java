package com.ecomm.beecasual.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class ProductSpecification {
	
	@Id
	private int productId;
	private String color;
	private String fabric;
	private String pattern;
	private String fit;
	private String washcare;
	private String style;
	private String size;
	
	
	@Transient
	private List<MultipartFile> image;
	
	@OneToOne
	@JoinColumn(name="productId", nullable=false,updatable=false, insertable=false)
	private Product product;

	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public List<MultipartFile> getImage() {
		return image;
	}

	public void setImage(List<MultipartFile> image) {
		this.image = image;
	}

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
