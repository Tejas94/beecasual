package com.ecomm.beecasual.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.beecasual.dao.BrandDAO;
import com.ecomm.beecasual.model.Brand;
import com.google.gson.Gson;




@Repository
public class BrandDAOImpl implements BrandDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public BrandDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}


	public void addBrand(Brand brand) {
		sessionFactory.getCurrentSession().saveOrUpdate(brand);
		
	}

	public List<Brand> getBrandList() {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Brand> brandList=session.createQuery("from Brand").getResultList();
		
		return brandList;

		
	}

	public Brand getBrandListById(int brandId) {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Brand> brandListById=session.createQuery("from Brand where brandId="+brandId).getResultList();
		return brandListById.get(0);
	}

	public void deleteBrand(int brandId) {
		Brand brandToDelete= new Brand();
		brandToDelete.setBrandId(brandId);;
		sessionFactory.getCurrentSession().delete(brandToDelete);
		
		
	}


	public Brand getBrandByName(String brandName) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Brand where brandName = "+"'"+brandName+"'";
		@SuppressWarnings("unchecked")
		List<Brand> brandListByName=session.createQuery(hql).getResultList();
		
		
		return brandListByName.get(0);}
	
	public String getJsonBrandList() {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Brand> brandList=session.createQuery("from Brand").getResultList();
		Gson gson=new Gson();
		String jsonBrandList=gson.toJson(brandList);
		
		return jsonBrandList;

		
	}

	
	
}
