package com.ecomm.beecasual.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.annotations.Expose;

@Entity
public class Product {
	
	@Id
	@Expose
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	@Expose
	private int subcategoryId;
	@Expose
	private int categoryId;
	@Expose
	private int supplierId;
	@Expose
	private int brandId;
	@Expose
	@NotEmpty(message="please enter name")
	private String productName;
	@Expose
	@NotEmpty(message="please enter name")
	private String productDescription;
	@Expose
	private int productQantity;
	@Expose
	private double productPrice;
	@Expose
	private double productDiscount;
	@Expose
	@Transient
	private List<MultipartFile> productImage;
	
	
	public List<MultipartFile> getProductImage() {
		return productImage;
	}

	public void setProductImage(List<MultipartFile> productImage) {
		this.productImage = productImage;
	}

	public int getProductQantity() {
		return productQantity;
	}

	public void setProductQantity(int productQantity) {
		this.productQantity = productQantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(double productDiscount) {
		this.productDiscount = productDiscount;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@ManyToOne
	@JoinColumn(name="categoryId", nullable=false,updatable=false, insertable=false)
	private Category category;

	@ManyToOne
	@JoinColumn(name="subcategoryId", nullable=false,updatable=false, insertable=false)
	private SubCategory subCategory;

	@ManyToOne
	@JoinColumn(name="supplierId", nullable=false,updatable=false, insertable=false)
	private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name="brandId", nullable=false,updatable=false, insertable=false)
	private Brand brand;
	



}
