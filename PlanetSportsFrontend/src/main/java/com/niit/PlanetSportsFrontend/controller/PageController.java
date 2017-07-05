package com.niit.PlanetSportsFrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
 
  /*	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("greeting","Welcome to Spring Web MVC..");
		return mv;
	}*/
}
