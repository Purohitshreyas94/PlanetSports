package com.niit.PlanetSportsFrontend.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.PlanetSportsBackend.dao.CategoryDAO;
import com.niit.PlanetSportsBackend.dao.ProductDAO;
import com.niit.PlanetSportsBackend.dao.UserDetailDAO;
import com.niit.PlanetSportsBackend.model.Cart;
import com.niit.PlanetSportsBackend.model.Product;
import com.niit.PlanetSportsBackend.model.UserDetail;

@Controller
@RequestMapping("/register")
public class UserController {
	
	@Autowired
	UserDetailDAO userdetailDAO;
	
	

	
	@RequestMapping(value = "/user",method=RequestMethod.GET)
	 public ModelAndView showUser(@RequestParam(name="operation",required=false)String operation)
	{
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("userClickSignup", true);
		mv.addObject("title", "Registration");
		UserDetail userdetail = new UserDetail();
		//Set the few fields
		//userdetail.setRole("User");
		
		
		if(operation!=null)
		{
			if(operation.equals("userdetail"))
			{
				mv.addObject("message", "All details are submitted successfully!You can login now!");
			}
		}
		
		return mv;
	}

	@RequestMapping(value = "/user", method=RequestMethod.POST)
	public String addUser(@RequestParam("username") String username, @RequestParam("custname") String custname,
			@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("mobile") String mobile,@RequestParam("address") String address,UserDetail muserdetail, Model model) {
		System.out.println("---Add User Starting-----");
		
		muserdetail.setUsername(username);
		muserdetail.setCustname(custname);
		muserdetail.setAddress(address);
		muserdetail.setEmail(email);
		muserdetail.setMobile(mobile);
		muserdetail.setPassword(password);
				
		userdetailDAO.validateUsername(username);
		if(muserdetail!=null)
		{
			model.addAttribute("duplicateUsername","Username already exists!Please try with new one!");
		}
		
		
		userdetailDAO.validateEmail(email);
		if(muserdetail!=null)
		{
			model.addAttribute("duplicateEmail","Email already exists!Please enter different Email Id!");
		}

	    
		userdetailDAO.validateCustomername(custname);
		if(muserdetail!=null)
		{
		    model.addAttribute("duplicateCustomername","Customername already exists!Please enter different Customername");	
		}
		
		
		userdetailDAO.insertUpdateUserDetail(muserdetail);
		//List<UserDetail> list = userdetailDAO.getUserDetailDetails();
		//m.addAttribute("UserDetail", list);

		System.out.println("---User Added----");
		return "redirect:/register/user?operation=userdetail";
	}
	
	
	
	
	
	
	
	
	
	
	
	

	/*
	@RequestMapping("/login_success")
	public String loginsuccess(HttpSession session,Model m) {
		System.out.println("loded successfully");
		boolean loggedIn = true;
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		session.setAttribute("username", username);
		session.setAttribute("loggedIn", loggedIn);
		System.out.println(username);
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();
		for (GrantedAuthority Role : authorities) {
			System.out.println("Role:" + Role.getAuthority() + "username" + username);

			if (Role.getAuthority().equals("ROLE_ADMIN")) {

				return "Admin";
			} else {
				
				return "Index";
			}
		}
		return "Home";
	}
	*/
	

}