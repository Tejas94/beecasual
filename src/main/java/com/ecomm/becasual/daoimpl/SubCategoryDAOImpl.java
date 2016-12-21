package com.ecomm.becasual.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.becasual.dao.SubCategoryDAO;
import com.ecomm.beecasual.model.Category;
import com.ecomm.beecasual.model.SubCategory;
import com.google.gson.Gson;
@Repository
public class SubCategoryDAOImpl implements SubCategoryDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public SubCategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	public void addSubCategory(SubCategory subCategory) {
		sessionFactory.getCurrentSession().saveOrUpdate(subCategory);
		
	}

	public List<SubCategory> getSubCategoryList() {
		Session session =sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<SubCategory> subCategoryList=session.createQuery("from SubCategory").getResultList();
		
		
		return subCategoryList;
	}

	public SubCategory getSubCategoryListById(int subcategoryId) {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<SubCategory> subCategoryListById=session.createQuery("from SubCategory where subcategoryId="+subcategoryId).getResultList();
		return subCategoryListById.get(0);
}

	public void deleteSubCategory(int subcategoryId) {
		SubCategory subCategoryToDelete= new SubCategory();
		subCategoryToDelete.setSubcategoryId(subcategoryId);
		sessionFactory.getCurrentSession().delete(subCategoryToDelete);
		
		
	}

	public SubCategory getSubCategoryByName(String subCategoryName) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from SubCategory where subcategoryName = "+"'"+subCategoryName+"'";
		@SuppressWarnings("unchecked")
		List<SubCategory> subCategoryListByName=session.createQuery(hql).getResultList();
		
		
		return subCategoryListByName.get(0);
	}
	
	public String getJsonSubCategoryList() {
		Session session =sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<SubCategory> subCategoryList=session.createQuery("from SubCategory").getResultList();
		Gson gson=new Gson();
		String jsonSubList=gson.toJson(subCategoryList);
		
		return jsonSubList;
	}


	

}
