package com.niit.PlanetSportsFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.PlanetSportsBackend.dao.CartItemDAO;
import com.niit.PlanetSportsBackend.dao.ProductDAO;
import com.niit.PlanetSportsBackend.dao.UserDetailDAO;
import com.niit.PlanetSportsBackend.model.Cart;
import com.niit.PlanetSportsBackend.model.CartItem;
import com.niit.PlanetSportsBackend.model.Product;
import com.niit.PlanetSportsBackend.model.UserDetail;

@Controller
public class CartItemController 
{
    @Autowired
	ProductDAO proudctDAO;
    @Autowired
    UserDetailDAO userdetailDAO;
    @Autowired
    CartItemDAO cartItemDAO;
    
    public CartItemController()
    {
    	System.out.println("In cart Cotroller page default constructor.");
    }
    
      @RequestMapping("/cart/getcart")
      public ModelAndView getCart(Model model)
      {
    	  System.out.println("get cart method");
    	  ModelAndView mv=new ModelAndView("index");
    	  mv.addObject("userClickCart", true);
    	  mv.addObject("title", "Cart");
      User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  		String username=user.getUsername();
  		 UserDetail userdetail=userdetailDAO.getByUsername(username);
  		 System.out.println("get cart method after 47 line");
  		Cart cart=userdetail.getCart();
  		 model.addAttribute("cart", cart);
  		 return mv;
      }
            
    
	@RequestMapping("/cart/add/{prodid}/product")
	public String addCartItem(@PathVariable int prodid, @RequestParam int units,Model model)
	{
	  ModelAndView mv=new ModelAndView("index");
	   mv.addObject("userClickCart",true);
       mv.addObject("title","Cart");
		Product product=proudctDAO.getProduct(prodid);
		
   //To get the user details, get the Principal object from securitycontextholder
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username=user.getUsername();
		 UserDetail userdetail=userdetailDAO.getByUsername(username);
		 Cart cart=userdetail.getCart();
		 List<CartItem> cartItems=cart.getCartItems();
		 System.out.println(cart.getCartItems().size());
		 
		 //check purchased product is already existing in the cartitem table
		 for(CartItem cartItem:cartItems){
			 //productid in table (productid in the database) == id(input)
			 System.out.println(cartItem.getProduct().getProdid());
			 System.out.println(prodid);
			  if(cartItem.getProduct().getProdid()==prodid)
			  {
				  cartItem.setQuantity(units);
				  cartItem.setTotalPrice(product.getPrice() * units);
				  cartItemDAO.addCartItem(cartItem);//update cartitem units & totalprice
				  return "redirect:/cart/getcart";
			  }
		 }
			 
         CartItem cartItem=new CartItem();
         cartItem.setQuantity(units);
         cartItem.setTotalPrice(product.getPrice() * units);
         cartItem.setProduct(product);//product_id column in cartItem table
         cartItem.setCart(cart);//cart_id column in cartitem table
         cartItemDAO.addCartItem(cartItem);//insert
         return "redirect:/cart/getcart";
		 
	}
		
	
	@RequestMapping("/cart/removecartitem/{cartItemId}")
		public String removeCartItem(@PathVariable int cartItemId)
	  {
		System.out.println("---Single CartItem Deleted----");
		 cartItemDAO.removeCartItem(cartItemId);
		return "redirect:/cart/getcart";
	  }
	
	
    @RequestMapping("/cart/clearcart/{cartid}")
	public String removeAllCartItems(@PathVariable("cartid") int cartid)
  {
    	System.out.println("---Cart Deleted----");
	 cartItemDAO.removeAllCartItem(cartid);;
	return "redirect:/cart/getcart";
  }

	
}
