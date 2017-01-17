package com.ecomm.beecasual.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.beecasual.dao.SupplierDAO;
import com.ecomm.beecasual.model.Supplier;
import com.google.gson.Gson;
@Repository
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	
	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}


	public void addSupplier(Supplier supplier)
	{
	
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
	}


	public List<Supplier> getSupplierList() {
		
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Supplier> supplierList=session.createQuery("from Supplier").getResultList();
		
		return supplierList;
	}


	public Supplier getSupplierById(int supplierId) {
		Session session=sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List<Supplier> supplierListById=session.createQuery("from Supplier where SupplierId="+supplierId).getResultList();
		return supplierListById.get(0);
	}


	public void deleteSupplier(int supplierId) {
		Supplier  supplierToDelete= new Supplier();
		supplierToDelete.setSupplierId(supplierId);
		sessionFactory.getCurrentSession().delete(supplierToDelete);
		
	}


	public Supplier getSupplierByName(String supplierName) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Supplier where supplierName = "+"'"+supplierName+"'";
		@SuppressWarnings("unchecked")
		List<Supplier> supplierListByName=session.createQuery(hql).getResultList();
		
		
		return supplierListByName.get(0);	}


		public String getJsonSupplierList() {
		
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Supplier> supplierList=session.createQuery("from Supplier").getResultList();
		Gson gson=new Gson();
		String jsonSupplierList=gson.toJson(supplierList);
		
		return jsonSupplierList;
	}





	


	
}
