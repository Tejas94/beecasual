package com.ecomm.becasual.dao;

import java.util.List;

import com.ecomm.beecasual.model.Product;



public interface ProductDAO {

    public void addProduct(Product product);
	
	public List<Product> getProductList();
	
	public Product getProductListById(int productId);
	
	public void deleteProduct(int productId);

}
