package com.ecomm.becasual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.becasual.daoimpl.CategoryDAOImpl;
import com.ecomm.beecasual.model.Category;

@Service
@Transactional
public class CategoryService 
{
	@Autowired
	CategoryDAOImpl categoryDAOImpl;
	
	
	public void addCategory(Category category)
	{
		categoryDAOImpl.addCategory(category);
	}
	
	public List<Category> getList()
	{
		
		
		return categoryDAOImpl.getList();
		
	}
	
	public Category getListById(int categoryId ){
		return categoryDAOImpl.getListById(categoryId);
		
	}
	
	public void deleteCategory(int categoryId)
	{
		categoryDAOImpl.deleteCategory(categoryId);
	}
public Category getCategoryByName(String categoryName){
		
		return categoryDAOImpl.getCategoryByName(categoryName);
	}

	public String getJsonList(){
		return categoryDAOImpl.getJsonList();
	}
}
