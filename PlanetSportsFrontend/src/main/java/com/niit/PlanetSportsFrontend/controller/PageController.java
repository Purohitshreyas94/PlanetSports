package com.niit.PlanetSportsFrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController 
{
   
	@RequestMapping("/aboutus")
	public String showAboutUs()
   {
	   return "aboutus";   
   }
 
  
}
