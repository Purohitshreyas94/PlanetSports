package com.niit.PlanetSportsFrontend.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExcpetionHandler 
{
     
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHanlderFoundException()
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "The Page is Not Constructed!..");
		
		mv.addObject("errorDescription", "The Page is Not Available!..");
        
		mv.addObject("title","404 Error Page");		
		
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException()
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Selected Product is not Available!..");
		
		mv.addObject("errorDescription", "The Page is Not Available right Now..please check after Some Time!..");
        
		mv.addObject("title","Product Unavailable");		
		
		return mv;
	}
	/*
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerForException(Exception ex)
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Contact your Admin!..");
		
		/*Only for debugging application
		StringWriter sw=new StringWriter();
		PrintWriter pw=new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		
		mv.addObject("errorDescription", sw.toString());
        
		mv.addObject("title","Error");		
		
		return mv;
	}*/
 }
