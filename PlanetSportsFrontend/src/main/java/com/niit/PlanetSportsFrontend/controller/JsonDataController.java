package com.niit.PlanetSportsFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.PlanetSportsBackend.dao.CategoryDAO;
import com.niit.PlanetSportsBackend.dao.ProductDAO;
import com.niit.PlanetSportsBackend.model.Category;
import com.niit.PlanetSportsBackend.model.Product;

@Controller
@RequestMapping("/json/data")

public class JsonDataController 
{
    
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/all/products")
	@ResponseBody
    
    public List<Product> getAllProducts()
    {
    	return productDAO.getProductDetails();
    }
	
	@RequestMapping("/admin/all/products")
	@ResponseBody
    
    public List<Product> getAllProductsForAdmin()
    {
    	return productDAO.getProductDetails();
    }
	
	
	@RequestMapping("/category/{catid}/products")
	@ResponseBody
    
    public List<Product> getProductByCategory(@PathVariable int catid)
    {
    	return productDAO.getProductByCategory(catid);
    }
	

	@RequestMapping("/admin/all/category")
	@ResponseBody
    
    public List<Category> getAllCategoryForAdmin()
    {
    	return categoryDAO.getCategoryDetails() ;
   
   }
}