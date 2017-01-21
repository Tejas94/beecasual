package com.ecomm.beecasual.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.beecasual.dao.ProductDAO;
import com.ecomm.beecasual.model.Product;
import com.ecomm.beecasual.model.ProductView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
		productToDelete.setProductId(productId);
		sessionFactory.getCurrentSession().delete(productToDelete);
		
		
	}
	
	public String getJsonProductList() {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Product> productList=session.createQuery("from Product").getResultList();
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String jsonProductList=gson.toJson(productList);
		
		return jsonProductList;
	}
	
	public ProductView getProductViewListById(int productId) {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ProductView> productListViewById=session.createQuery("from ProductView where productId="+productId).getResultList();
		return productListViewById.get(0);
	}
	
	public String getProductViewList() {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ProductView> productListView=session.createQuery("from ProductView").getResultList();
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json=gson.toJson(productListView);
		return json;
	}

	
	public void updateQuantity(int productId,int quantity)
	{
		
		String hql="update Product set productQantity= productQantity -"+quantity+" where productId="+productId;
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
	}
	
	public void updateQuantity1(int productId,int quantity)
	{
		
		String hql="update Product set productQantity= productQantity +"+quantity+" where productId="+productId;
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
	}


}


