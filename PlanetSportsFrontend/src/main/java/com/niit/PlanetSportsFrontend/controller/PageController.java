package com.niit.PlanetSportsFrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class PageController 
{
   
	@RequestMapping("/aboutus")
	public String showAboutUs()
   {
	   return "aboutus";   
   }
 
}
