package com.ecomm.beecasual.dao;

import java.util.List;

import com.ecomm.beecasual.model.Brand;




public interface BrandDAO {

	public void addBrand(Brand brand);
	
	public List<Brand> getBrandList();
	
	public Brand getBrandListById(int brandId);
	
	public void deleteBrand(int brandId);
	
	public Brand getBrandByName(String brandName);

}
