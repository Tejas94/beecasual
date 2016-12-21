package com.ecomm.becasual.dao;

import java.util.List;


import com.ecomm.beecasual.model.Supplier;

public interface SupplierDAO {

	
		public void addSupplier(Supplier supplier);
		
		public List<Supplier> getSupplierList();
		
		public Supplier getSupplierById(int supplierId);
		
		public void deleteSupplier(int supplierId);
		
		public Supplier getSupplierByName(String supplierName);
}
