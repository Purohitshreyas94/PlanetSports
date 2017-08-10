package com.niit.PlanetSportsFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.PlanetSportsBackend.dao.CartItemDAO;
import com.niit.PlanetSportsBackend.dao.UserOrderDAO;
import com.niit.PlanetSportsBackend.model.Cart;
import com.niit.PlanetSportsBackend.model.UserDetail;
import com.niit.PlanetSportsBackend.model.UserOrder;

@Controller
public class UserOrderController 
{
	 @Autowired
	 UserOrderDAO userorderDAO;
	 @Autowired
	 CartItemDAO cartitemDAO;

	 @RequestMapping("/cart/{cartid}/order")
		public ModelAndView createOrder(@PathVariable int cartid,Model model)
		{
			   ModelAndView mv=new ModelAndView("index");
			   mv.addObject("userClickOrder", true);
			   mv.addObject("title", "Order");
				Cart cart=cartitemDAO.getCart(cartid);
				UserDetail userdetail=cart.getUserdetail();
			    cart.setUserdetail(userdetail);
			UserOrder userorder=userorderDAO.createOrder(cart);
			model.addAttribute("cart",cart);
			model.addAttribute("order",userorder);
			model.addAttribute("cartid",cartid);
		//	return "orderdetails";
			return mv;
		}
		
		@RequestMapping("/cart/confirm/{cartid}")
		public ModelAndView confirm(@ModelAttribute UserOrder order,@PathVariable int cartid,Model model)
		{
			ModelAndView mv=new ModelAndView("index");	
			   mv.addObject("userClickConfirmOrder", true);
			   mv.addObject("title", "Visit Again!");
			   
			   model.addAttribute("order",order);
			  
			   
			cartitemDAO.removeAllCartItem(cartid);
			//return "thanks";
		   return mv;
		}

}
