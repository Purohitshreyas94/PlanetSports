package com.niit.PlanetSportsFrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController 
{
    
  /*	@RequestMapping("/")
	public String showIndex()
   {
	   
		System.out.println("Index page displaying....");
		return "index";   
   }*/
	
	@RequestMapping("/aboutus")
	public String showAboutUs()
   {
	   System.out.println("About us page displaying..");
		return "aboutus";   
   }
 
}
