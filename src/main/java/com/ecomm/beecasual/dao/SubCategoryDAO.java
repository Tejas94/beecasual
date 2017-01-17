package com.ecomm.beecasual.dao;

import java.util.List;


import com.ecomm.beecasual.model.SubCategory;



public interface SubCategoryDAO {
	
	public void addSubCategory(SubCategory subCategory);
	
	public List<SubCategory> getSubCategoryList();
	
	public SubCategory getSubCategoryListById(int subcategoryId);
	
	public void deleteSubCategory(int subcategoryId);
	
	public SubCategory getSubCategoryByName(String subCategoryName);


}
