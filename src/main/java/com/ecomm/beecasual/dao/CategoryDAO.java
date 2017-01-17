package com.ecomm.beecasual.dao;

import java.util.List;

import com.ecomm.beecasual.model.Category;

public interface CategoryDAO {

		public void addCategory(Category category);
		
		public List<Category> getList();
		
		public Category getListById(int categoryId);
		
		public void deleteCategory(int categoryId);
	
		public Category getCategoryByName(String categoryName);
}
