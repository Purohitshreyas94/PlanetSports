package com.niit.PlanetSportsFrontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.PlanetSportsBackend.dao.CategoryDAO;
import com.niit.PlanetSportsBackend.dao.ProductDAO;
import com.niit.PlanetSportsBackend.model.Category;
import com.niit.PlanetSportsBackend.model.Product;
import com.niit.PlanetSportsFrontend.util.FileUploadUtility;
import com.niit.PlanetSportsFrontend.validator.ProductValidator;

@Controller
@RequestMapping("/manageproduct")
public class ProductController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation)
	{
		ModelAndView mv= new ModelAndView("index");
		mv.addObject("userCLickManageProducts", true);
		mv.addObject("title","Manage Products");
		
		Product nProduct = new Product();
		nProduct.setSuppid(0);
		
		mv.addObject("product",nProduct);
		
		if(operation!=null)
		{
			if(operation.equals("product"))
			{
				mv.addObject("message", "Product Submitted Successfully!..");
			}
		}
		
		return mv;
		
	}
	
	//Product Insertion
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@ModelAttribute("product") Product mproduct, BindingResult results, Model model,HttpServletRequest request)
	{  
		
		new ProductValidator().validate(mproduct,results);
		
		
		 
		//create a new Product Record
		productDAO.insertUpdateProduct(mproduct);
		
		if(!mproduct.getFile().getOriginalFilename().equals(""))
		{
			FileUploadUtility.uploadFile(request,mproduct.getFile(),mproduct.getProdid());
		}
		return "redirect:/manage/products?operation=product";
		
	}
	
	
	
	
	
	//returning Category for all MAppings
	@ModelAttribute("category")
	public List<Category> getCategory()
	{
		return categoryDAO.list();
	}
}
