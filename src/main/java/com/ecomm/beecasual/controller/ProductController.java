package com.ecomm.beecasual.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.becasual.service.BrandService;
import com.ecomm.becasual.service.CategoryService;
import com.ecomm.becasual.service.ProductService;
import com.ecomm.becasual.service.ProductSpecificationService;
import com.ecomm.becasual.service.SubCategoryService;
import com.ecomm.becasual.service.SupplierService;
import com.ecomm.beecasual.model.Brand;
import com.ecomm.beecasual.model.Category;
import com.ecomm.beecasual.model.Product;
import com.ecomm.beecasual.model.ProductSpecification;
import com.ecomm.beecasual.model.ProductView;
import com.ecomm.beecasual.model.SubCategory;
import com.ecomm.beecasual.model.Supplier;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



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
	@Autowired
	ProductSpecificationService productSpecificationService;
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
		model.addAttribute("categoryListDrop", categoryService.getList());
		return "/product";
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(Model model, @Valid @ModelAttribute("product") Product product, BindingResult bindingresult,@RequestParam("files") List<MultipartFile> productImage){
		
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
        
        
        
        
        List<MultipartFile> files=productImage;
        
        for( int i=0;i<=files.size();i++)
        {
        try{
        	MultipartFile multipartFile=files.get(i);
        	String path="D:\\tejas\\ecomm\\BeeCasual\\src\\main\\webapp\\resources\\images\\";
            path=path+String.valueOf(product.getProductId()+"-"+i+".jpg");
            java.io.File file= new java.io.File(path);
            byte[] bytes;
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
		@RequestMapping("/productspecification-{productId}")
		public String productInfo(Model model,@PathVariable("productId") int productId,@ModelAttribute("productspecification") ProductSpecification productSpecification)
		{
			productService.getProductListById(productId);
			productSpecification.setProductId(productId);
			model.addAttribute("productInfo",productSpecification);
			return "/productspecification";
			
		}
		
		@RequestMapping("/addInfo")
		public String addInfo(Model model,@ModelAttribute("prodpructspecification") ProductSpecification productSpecification)
		{
			this.productSpecificationService.addSpecification(productSpecification);
			return "redirect:/product";
		}
		
		
		
		@RequestMapping("/viewproduct-{productId}")
		public String viewProduct(Model model,@PathVariable("productId") int productId)
		{
			
			Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			String viewlist= gson.toJson(productService.getProductViewListById(productId));
			model.addAttribute("product",viewlist);
			
			return "/viewproduct";
			
		}
		
		
		


}
