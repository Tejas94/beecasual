package com.ecomm.beecasual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.beecasual.daoimpl.ProductSpecificationDAOImpl;
import com.ecomm.beecasual.model.ProductSpecification;

@Service
@Transactional
public class ProductSpecificationService {
	@Autowired
	ProductSpecificationDAOImpl productSpecificationDAOImpl;
	
	public void addSpecification(ProductSpecification productSpecification)
	{
		
		productSpecificationDAOImpl.addSpecification(productSpecification);
	}

}
