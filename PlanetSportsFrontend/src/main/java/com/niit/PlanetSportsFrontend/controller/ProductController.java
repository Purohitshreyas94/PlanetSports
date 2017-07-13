package com.niit.PlanetSportsFrontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
@RequestMapping("/manage")

public class ProductController 
{
	
	@Autowired 
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
    @RequestMapping(value="/products", method=RequestMethod.GET)
    public ModelAndView showManageProducts(@RequestParam(name="operation",required=false)String operation)
    {
    	
        ModelAndView mv=new ModelAndView("index");
        mv.addObject("userClickManageProducts",true);
        mv.addObject("title","Manage Products");
        Product nProduct = new Product();
        
        
        //set few of the fields
        nProduct.setSuppid(0);
        
        mv.addObject("product", nProduct);
        
        if(operation!=null)
        {
        	if(operation.equals("product"))
        	{
        		mv.addObject("message","Product Submitted Successfully!...");
        	}
        }
        
         return mv;
    
    }
    
    
    //handling product submission
    @RequestMapping(value="/products", method=RequestMethod.POST)
    public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results, Model model, 
    		HttpServletRequest request)
    {
    	
    	new ProductValidator().validate(mProduct,results);
    	
    	
    	//check if there are any errors
    	if(results.hasErrors())
    	{
    		
            model.addAttribute("userClickManageProducts", true);
            model.addAttribute("title", "Manage Products");
    		model.addAttribute("message", "Validation failed for Product Submission");
            return "index";
    	}
    	
    	
    	//create a new Product Record
    	productDAO.insertUpdateProduct(mProduct);
    	
    	if(!mProduct.getFile().getOriginalFilename().equals(""))
    	{
    		FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getProdid());
    	}
    	
    	
    	return "redirect:/manage/products?operation=product"; 
    }
    
    
    // Returning Categories For All the Products
    @ModelAttribute("category")
    public List<Category> getCategory()
    {
		return categoryDAO.getCategoryDetails();
    }
	
}
