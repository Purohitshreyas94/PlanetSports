package com.niit.PlanetSportsFrontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.PlanetSportsBackend.dao.CategoryDAO;

import com.niit.PlanetSportsBackend.model.Category;

import com.niit.PlanetSportsFrontend.util.FileUploadUtility;
import com.niit.PlanetSportsFrontend.validator.ProductValidator;

@Controller
@RequestMapping("/manage")

public class CategoryController 
{
	
	@Autowired 
	CategoryDAO categoryDAO;
	
	
	
    @RequestMapping(value="/category", method=RequestMethod.GET)
    public ModelAndView showManageProducts(@RequestParam(name="operation",required=false)String operation)
    {
    	
        ModelAndView mv=new ModelAndView("index");
        mv.addObject("userClickManageCategory",true);
        mv.addObject("title","Manage Category");
        Category nCategory = new Category();
        
        
        mv.addObject("category", nCategory);
        
        if(operation!=null)
        {
        	if(operation.equals("category"))
        	{
        		mv.addObject("message","Category Submitted Successfully!...");
        	}
        }
        
         return mv;
    
    }
    
    
    //For the Updating the Product
    @RequestMapping(value="/{catid}/category",method=RequestMethod.GET)
    public ModelAndView showEditCategory(@PathVariable int catid)
    {
    	
        ModelAndView mv=new ModelAndView("index");
        mv.addObject("userClickManageCategory",true);
        mv.addObject("title","Manage Category");
        
        
        //fetch the Category from Database
        Category nCategory = categoryDAO.getCategory(catid);
       
        //set the category fetch from database
        mv.addObject("category", nCategory);
        
        return mv;
    
    }
    

    //For the Deleting the Category
    @RequestMapping(value="/{catid}/delete/category",method=RequestMethod.GET)
    public String showDeleteCategory(@PathVariable int catid,Model model)
    {
    	
      // ModelAndView mv=new ModelAndView("index");
        //mv.addObject("userClickManageCategory",true);
        //mv.addObject("title","Manage Category");
    	System.out.println("---Category Deleted----");
		Category category=categoryDAO.getCategory(catid);
		categoryDAO.deleteCategory(category);

        
        //fetch the category from Database
       // Category category = categoryDAO.getCategory(catid);
        //categoryDAO.deleteCategory(category);
        
        return "redirect:/manage/category";
    
    }
    
    
    
    //handling category submission
    @RequestMapping(value="/category", method=RequestMethod.POST)
    public String handleProductSubmission(@Valid @ModelAttribute("category") Category mCategory, BindingResult results, Model model, 
    		HttpServletRequest request)
    {
    	
    	    	
    	//check if there are any errors
    	if(results.hasErrors())
    	{
    		
            model.addAttribute("userClickManageCategory", true);
            model.addAttribute("title", "Manage Category");
    		model.addAttribute("message", "Validation failed for Category Submission");
            return "index";
    	}
    	
    	
    	//create a new Category Record
    	if(mCategory.getCatid()==0)
    	{	
           categoryDAO.insertUpdateCategory(mCategory);
    	}
    	else
    	{ 
    		//update the Product if id is not 0
    		categoryDAO.insertUpdateCategory(mCategory);
    	}
    	
    	
    	
    	return "redirect:/manage/category?operation=category"; 
    }
    
    
    
}
