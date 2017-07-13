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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.PlanetSportsBackend.dao.CategoryDAO;
import com.niit.PlanetSportsBackend.dao.ProductDAO;
import com.niit.PlanetSportsBackend.dao.UserDetailDAO;
import com.niit.PlanetSportsBackend.model.Product;
import com.niit.PlanetSportsBackend.model.UserDetail;

@Controller
public class UserController {
	
	UserDetailDAO userdetailDAO;
	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	ProductDAO productDAO;
	
 

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
	

	@RequestMapping(value = "/${contextRoot}/signup")
	public String addUser(@RequestParam("username") String username, @RequestParam("custname") String custName,
			@RequestParam("email") String email, @RequestParam("password") String password,
			@RequestParam("address") String address, @RequestParam("mobile") String mobile, Model m) {
		System.out.println("---Add User Starting-----");

		ModelAndView mv= new ModelAndView("index");
		mv.addObject("useruserClickSignup", true);
		mv.addObject("title","Registration");
		
		UserDetail userdetail = new UserDetail();
		userdetail.setCustname(custName);
		userdetail.setAddress(address);
		userdetail.setEmail(email);
		userdetail.setMobile(mobile);
		userdetail.setUsername(username);
		userdetail.setPassword(password);
		userdetail.setRole("User");

		userdetailDAO.insertUpdateUserDetail(userdetail);

		 
		List<UserDetail> list = userdetailDAO.getUserDetailDetails();
		m.addAttribute("UserDetail", list);

		System.out.println("---User Added----");
		return "signup";
	}
}