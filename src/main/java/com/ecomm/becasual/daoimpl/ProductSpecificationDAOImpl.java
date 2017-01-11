package com.ecomm.becasual.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.becasual.dao.ProductSpecificationDAO;
import com.ecomm.beecasual.model.ProductSpecification;
@Repository
public class ProductSpecificationDAOImpl implements ProductSpecificationDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public ProductSpecificationDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	
	public void addSpecification(ProductSpecification productSpecification) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(productSpecification);
	}

}
