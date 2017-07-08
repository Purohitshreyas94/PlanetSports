package com.niit.PlanetSportsFrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController 
{
    
	
	@RequestMapping("/aboutus")
	public String showAboutUs()
   {
	   System.out.println("About us page displaying..");
		return "aboutus";   
   }
 
  	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("index");
		return mv;
	}
  	
  	@RequestMapping("/account")
	public String showAccount()
   {
	   System.out.println("Account page displaying..");
		return "account";   
   }
  	
  	@RequestMapping("/contactus")
	public String showContactUs()
   {
	   System.out.println("ContactUs page displaying..");
		return "contactus";   
   }
  	
}
