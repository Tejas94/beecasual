package com.ecomm.becasual.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.becasual.dao.ProductDAO;
import com.ecomm.beecasual.model.Product;
import com.google.gson.Gson;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		
	}

	public List<Product> getProductList() {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Product> productList=session.createQuery("from Product").getResultList();
		
		return productList;}

	public Product getProductListById(int productId) {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Product> productListById=session.createQuery("from Product where productId="+productId).getResultList();
		return productListById.get(0);
	}

	public void deleteProduct(int productId) {
		Product productToDelete= new Product();
		productToDelete.setCategoryId(productId);
		sessionFactory.getCurrentSession().delete(productToDelete);
		
		
	}
	
	public String getJsonProductList() {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Product> productList=session.createQuery("from Product").getResultList();
		Gson gson=new Gson();
		String jsonProductList=gson.toJson(productList);
		
		return jsonProductList;}


}
