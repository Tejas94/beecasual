package com.ecomm.beecasual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.beecasual.daoimpl.SubCategoryDAOImpl;
import com.ecomm.beecasual.model.Category;
import com.ecomm.beecasual.model.SubCategory;

@Service
@Transactional
public class SubCategoryService {
	@Autowired
	private SubCategoryDAOImpl subCategoryDAOImpl;
	
	public void addSubCategory(SubCategory subCategory){
		subCategoryDAOImpl.addSubCategory(subCategory);
		
	}
	
	public List<SubCategory> getSubCategoryList(){
		return subCategoryDAOImpl.getSubCategoryList();
	}
	
	public SubCategory getSubCategoryListById(int subcategoryId){
		return subCategoryDAOImpl.getSubCategoryListById(subcategoryId);
	}
	
	public void deleteSubCategory(int subcategoryId){
		subCategoryDAOImpl.deleteSubCategory(subcategoryId);
	}
	
	public SubCategory getSubCategoryByName(String subCategoryName){
		return subCategoryDAOImpl.getSubCategoryByName(subCategoryName);
	}

	public String getJsonSubCategoryList(){
		return subCategoryDAOImpl.getJsonSubCategoryList();
	}
	
}
