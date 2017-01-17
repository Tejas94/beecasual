package com.ecomm.beecasual.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.beecasual.dao.CategoryDAO;
import com.ecomm.beecasual.model.Category;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	
	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}


	public void addCategory(Category category)
	{
	
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}



	public List<Category> getList() {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Category> categoryList=session.createQuery("from Category").getResultList();
		
		return categoryList;
	}


	public Category getListById(int categoryId ) {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Category> categoryListById=session.createQuery("from Category where CategoryId="+categoryId).getResultList();
		return categoryListById.get(0);
	}


	public void deleteCategory(int categoryId) {
		Category categoryToDelete= new Category();
		categoryToDelete.setCategoryId(categoryId);
		sessionFactory.getCurrentSession().delete(categoryToDelete);
		
	}

	public Category getCategoryByName(String categoryName) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Category where categoryName = "+"'"+categoryName+"'";
		@SuppressWarnings("unchecked")
		List<Category> categoryListByName=session.createQuery(hql).getResultList();
		
		
		return categoryListByName.get(0);
	}

	public String getJsonList() {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Category> categoryList=session.createQuery("from Category").getResultList();
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String jsonList=gson.toJson(categoryList);
		
		return jsonList;
	}
	
	
	


	}


