package com.niit.PlanetSportsFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.PlanetSportsBackend.dao.CartItemDAO;
import com.niit.PlanetSportsBackend.dao.CategoryDAO;
import com.niit.PlanetSportsBackend.dao.ProductDAO;
import com.niit.PlanetSportsBackend.dao.UserDetailDAO;
import com.niit.PlanetSportsBackend.dao.UserOrderDAO;
import com.niit.PlanetSportsBackend.model.Cart;
import com.niit.PlanetSportsBackend.model.Category;
import com.niit.PlanetSportsBackend.model.Product;
import com.niit.PlanetSportsBackend.model.UserDetail;
import com.niit.PlanetSportsBackend.model.UserOrder;
import com.niit.PlanetSportsFrontend.exception.ProductNotFoundException;

@Controller
public class PageController 
{
    @Autowired
    CategoryDAO categoryDAO;
	
    @Autowired
    ProductDAO productDAO;
    
    @Autowired
    UserDetailDAO userdetailDAO;
    
    @Autowired
	 UserOrderDAO userorderDAO;
    
	 @Autowired
	 CartItemDAO cartitemDAO;
	
  	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("title","Home");
		mv.addObject("userClickHome",true);
		
		//Passing the list of Categories
		mv.addObject("list",categoryDAO.getCategoryDetails());
		return mv;
	}
  	
  	@RequestMapping(value = {"/about","/Read More"})
	public ModelAndView showAboutUs()
   {
		ModelAndView mv=new ModelAndView("index");
	   System.out.println("About us page displaying..");
	   mv.addObject("title","About Us");
	   mv.addObject("userClickAbout",true);
		return mv;   
   }
  	
	@RequestMapping(value = "/contact")
	public ModelAndView showContact()
   {
		ModelAndView mv=new ModelAndView("index");
	   System.out.println("Contact page displaying..");
	   mv.addObject("title","Contact Us");
	   mv.addObject("userClickContact",true);
		return mv;   
   }
  	
   	
  	
  	/*This is for Login*/
  	
  	@RequestMapping(value= "/login")
	public ModelAndView login(@RequestParam(name="error",required = false)String error)
   {
  		ModelAndView mv=new ModelAndView("login");
	   System.out.println("Login page displaying..");
	   
	   if(error!=null)
	   {
		   mv.addObject("message","Invalid Username and Password! Please try again!.");
	   }			   
	   mv.addObject("title","Login");
	   return mv;   
   }
  	
 
  	
  	/*
          Methods to show all products and based on Category.
   	*/
     
  	@RequestMapping(value= "/show/all/products")
	public ModelAndView showAllProducts()
	{
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("title","All Products");
		//Passing the list of Categories
		mv.addObject("list",categoryDAO.getCategoryDetails());
		mv.addObject("userClickProducts", true);
		return mv;
	}
    
  	@RequestMapping(value= "/show/category/{catid}/products")
	public ModelAndView showCategoryProducts(@PathVariable("catid") int catid )
	{
		ModelAndView mv=new ModelAndView("index");
		Category category = null;
		category = categoryDAO.getCategory(catid);
		
		mv.addObject("title",category.getCatname());
		
		//Passing the list of Categories
		mv.addObject("Categories",categoryDAO.getCategoryDetails());
		
		//Passing the single Category Object
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		
		return mv;
	}
  	
  	
  	//Showing Single Product
  	@RequestMapping(value = "/show/{prodid}/product")
  	public ModelAndView showSingleProduct(@PathVariable int prodid)throws ProductNotFoundException
  	{
  		ModelAndView mv=new ModelAndView("index");
		Product product=productDAO.getProduct(prodid);
		
		if(product == null)throw new  ProductNotFoundException();
		
		mv.addObject("title", product.getProdname());
		mv.addObject("product",product);
		
		mv.addObject("userClickShowProduct", true);
  		
  		return mv;
  		
  	}
  	
  	
  	//Access denied page
	@RequestMapping(value ="/access-denied")
	public ModelAndView accessDenied()
   {
		ModelAndView mv=new ModelAndView("error");
	   mv.addObject("title","403 - Access Denied");
	   mv.addObject("errorTitle","Excuse me!Wrong Place! ");
	   mv.addObject("errorDescription","You are not authorized to view this Page!");
		return mv;   
   }
	
  	
} 

