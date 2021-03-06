package com.ecomm.beecasual.model;

import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

@Entity
public class Category
{
	@Id
	@Expose
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryId;
	@Expose
	@NotEmpty(message="please enter name")
	@Pattern(regexp="([a-zA-Z]{1})+[a-zA-Z0-9]+" ,message="enter valid name")
	private String categoryName;
	@Expose
	@NotEmpty(message="please enter description")
	private String categoryDescription;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	@Expose
	@OneToMany(mappedBy="category", fetch=FetchType.EAGER)
	private Set<SubCategory> subCategory;
	public Set<SubCategory> getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(Set<SubCategory> subCategory) {
		this.subCategory = subCategory;
	}
	
	
}
