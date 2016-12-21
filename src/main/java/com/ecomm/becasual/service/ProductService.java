package com.ecomm.becasual.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.becasual.daoimpl.ProductDAOImpl;
import com.ecomm.beecasual.model.Product;

@Service
@Transactional
public class ProductService {
	@Autowired
	ProductDAOImpl productDAOImpl;
	
	public void addProduct(Product product){
		productDAOImpl.addProduct(product);
	}
	
	public List<Product> getProductList(){
		return productDAOImpl.getProductList();
	}
	
	public Product getProductListById(int productId){
		return productDAOImpl.getProductListById(productId);
	}
	
	public void deleteProduct(int productId){
		productDAOImpl.deleteProduct(productId);
	}
	
	public String getJsonProductList(){
		return productDAOImpl.getJsonProductList();
	}

}
