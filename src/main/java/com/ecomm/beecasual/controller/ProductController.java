package com.ecomm.beecasual.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.becasual.service.BrandService;
import com.ecomm.becasual.service.CategoryService;
import com.ecomm.becasual.service.ProductService;
import com.ecomm.becasual.service.SubCategoryService;
import com.ecomm.becasual.service.SupplierService;
import com.ecomm.beecasual.model.Brand;
import com.ecomm.beecasual.model.Category;
import com.ecomm.beecasual.model.Product;
import com.ecomm.beecasual.model.SubCategory;
import com.ecomm.beecasual.model.Supplier;



@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	 SubCategoryService subCategoryService;
	@Autowired
	 CategoryService categoryService;
	@Autowired
	SupplierService supplierService;
	@Autowired
	BrandService brandService;
	
	
	@RequestMapping("/product")
	public String getSubCategory(Model model){
		model.addAttribute("subcategory", new SubCategory());
		model.addAttribute("category",new Category());
		model.addAttribute("categoryList", categoryService.getList());
		model.addAttribute("subCategoryList",subCategoryService.getSubCategoryList());
		model.addAttribute("product", new Product());
		model.addAttribute("productList",productService.getJsonProductList());
		model.addAttribute("brand", new Brand());
		model.addAttribute("brandList",brandService.getBrandList());
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("supplierList",supplierService.getSupplierList());
		return "/product";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(Model model, @Valid @ModelAttribute("product") Product product, BindingResult bindingresult){
		
		if(bindingresult.hasErrors()){
			
			return "/product";
		}
		else
		{
		Category category=categoryService.getCategoryByName(product.getCategory().getCategoryName());
        product.setCategory(category);
		product.setCategoryId(category.getCategoryId());
		
		SubCategory subCategory=subCategoryService.getSubCategoryByName(product.getSubCategory().getSubCategoryName());
		product.setSubCategory(subCategory);
		product.setSubcategoryId(subCategory.getSubcategoryId());
		
		Supplier supplier=supplierService.getSupplierByName(product.getSupplier().getSupplierName());
		product.setSupplier(supplier);
		product.setSupplierId(supplier.getSupplierId());
		
		Brand brand=brandService.getBrandByName(product.getBrand().getBrandName());
		product.setBrand(brand);
		product.setBrandId(brand.getBrandId());
		
        productService.addProduct(product);
        
        String path="D:\\tejas\\ecomm\\BeeCasual\\src\\main\\webapp\\resources\\images\\";
        path=path+String.valueOf(product.getProductId()+".jpg");
        
        java.io.File file= new java.io.File(path);
        
        MultipartFile multipartFile=product.getProductImage();
        
        byte[] bytes;
        try{
        	
        bytes = multipartFile.getBytes();
        FileOutputStream fos = new FileOutputStream(file);
        BufferedOutputStream bos= new BufferedOutputStream(fos);
        bos.write(bytes);
        bos.close();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        
		return "redirect:/product";
		
		}	
		}
		
		@RequestMapping("/editProduct-{productId}")
		public String editProduct(Model model,@PathVariable("productId") int productId){
		
		model.addAttribute("product", productService.getProductListById(productId));
		model.addAttribute("supplierList",supplierService.getSupplierList());
		model.addAttribute("categoryList", categoryService.getList());
		model.addAttribute("subCategoryList",subCategoryService.getSubCategoryList());
		model.addAttribute("brandList",brandService.getBrandList());
		
		return "/product";
	
	}
		@RequestMapping("/deleteProduct-{productId}")
		public String deleteProduct(@PathVariable("productId") int productId)
		{
		productService.deleteProduct(productId);
		return "redirect:/product";
		}
		
		
		


}
