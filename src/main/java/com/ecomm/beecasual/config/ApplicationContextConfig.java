package com.ecomm.beecasual.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.becasual.daoimpl.BrandDAOImpl;
import com.ecomm.becasual.daoimpl.CategoryDAOImpl;
import com.ecomm.becasual.daoimpl.ProductDAOImpl;
import com.ecomm.becasual.daoimpl.SubCategoryDAOImpl;
import com.ecomm.becasual.daoimpl.SupplierDAOImpl;
import com.ecomm.becasual.service.BrandService;
import com.ecomm.becasual.service.CategoryService;
import com.ecomm.becasual.service.ProductService;
import com.ecomm.becasual.service.SubCategoryService;
import com.ecomm.becasual.service.SupplierService;
import com.ecomm.beecasual.model.Brand;
import com.ecomm.beecasual.model.Category;
import com.ecomm.beecasual.model.Product;
import com.ecomm.beecasual.model.ProductSpecification;
import com.ecomm.beecasual.model.SubCategory;
import com.ecomm.beecasual.model.Supplier;
 
@Configuration
@EnableTransactionManagement
@ComponentScan( "com.ecomm.beecasual" )

public class ApplicationContextConfig {
 
   
   
     
    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/beecasual");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        
        Properties dproperties= new Properties();
        dproperties.setProperty("hibernate.show_sql", "true");
        dproperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        dproperties.setProperty("hibernate.hbm2ddl.auto","update");
     
        return dataSource;
    }
     
    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto","update");
        return properties;
    }
    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(
            SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(
                sessionFactory);
     
        return transactionManager;
    }
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
     
        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.addProperties(getHibernateProperties());
     
        sessionBuilder.addAnnotatedClasses(Category.class);
        sessionBuilder.addAnnotatedClass(Supplier.class);
        sessionBuilder.addAnnotatedClass(SubCategory.class);
        sessionBuilder.addAnnotatedClass(Brand.class);
        sessionBuilder.addAnnotatedClass(Product.class);
        sessionBuilder.addAnnotatedClass(ProductSpecification.class);
        return sessionBuilder.buildSessionFactory();
    }
    
    @Autowired
    @Bean("categoryDAOImpl")
    public CategoryDAOImpl getCategory(SessionFactory sessionFactory) {
    	return new CategoryDAOImpl(sessionFactory);
    }
    @Autowired
    @Bean("categoryService")
    public CategoryService getCategoryService() {
    	return new CategoryService();
    }
  
    @Autowired
    @Bean("supplierDAOImpl")
    public SupplierDAOImpl getSupplier(SessionFactory sessionFactory) {
    	return new SupplierDAOImpl(sessionFactory);
    }
    @Autowired
    @Bean("supplierService")
    public SupplierService getSupplierService() {
    	return new SupplierService();
    }
    @Autowired
    @Bean("subCategoryDAOImpl")
    public SubCategoryDAOImpl getSubCategory(SessionFactory sessionFactory) {
    	return new SubCategoryDAOImpl(sessionFactory);
    }
    @Autowired
    @Bean("subCategoryService")
    public SubCategoryService getSubCategoryService() {
    	return new SubCategoryService();
    }
  
    @Autowired
    @Bean("brandDAOImpl")
    public BrandDAOImpl getBrand(SessionFactory sessionFactory) {
    	return new BrandDAOImpl(sessionFactory);
    }
    @Autowired
    @Bean("brandService")
    public BrandService getBrandService() {
    	return new BrandService();
    }
    
    @Autowired
    @Bean("productDAOImpl")
    public ProductDAOImpl getProduct(SessionFactory sessionFactory) {
    	return new ProductDAOImpl(sessionFactory);
    }
    @Autowired
    @Bean("productService")
    public ProductService getProductService() {
    	return new ProductService();
    }

}