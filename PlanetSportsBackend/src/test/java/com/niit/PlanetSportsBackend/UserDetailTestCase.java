package com.niit.PlanetSportsBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.PlanetSportsBackend.dao.UserDetailDAO;
import com.niit.PlanetSportsBackend.model.UserDetail;


public class UserDetailTestCase 
{
	public static void main(String args[])
	{

		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.PlanetSportsBackend");
		context.refresh();
		
		
		//Inserting a UserDetail object
		UserDetailDAO userdetailDAO=(UserDetailDAO)context.getBean("userdetailDAO");
		
		//Inserting Test Case
	  	UserDetail userdetail=new UserDetail();
		 userdetail.setUsername("assd");
		 userdetail.setAddress("India");
	    userdetail.setCustname("Shreyas123");
	    userdetail.setEmail("xyz@gmail.com");
	    userdetail.setEnabled(true);
	    userdetail.setMobile("12456789");
	    userdetail.setPassword("shreyas@123");
	    userdetail.setRole(null);
	   
		userdetailDAO.insertUpdateUserDetail(userdetail);
		System.out.println("User Details Inserted..");
		
		
		//Retrieval TestCase
		 /*
		UserDetail userdetail=userdetailDAO.getUserDetail("shreyas");
				System.out.println("User Address:"+userdetail.getAddress());
				System.out.println("Customer Name:"+userdetail.getCustname());
				System.out.println("User Email:"+userdetail.getEmail());
				System.out.println("User Mobile Number:"+userdetail.getMobile());
				System.out.println("User Password :"+userdetail.getPassword());
				System.out.println("User Role:"+userdetail.getRole());
	        
	        	
				
		//Retrieving the Data
		
			  List<UserDetail> list=userdetailDAO.getUserDetailDetails();
				
				for(UserDetail userdetail:list)
				{
					System.out.println(userdetail.getUsername()+":"+userdetail.getAddress()+":"+userdetail.getCustname()+":"+userdetail.getEmail()+":"+userdetail.getMobile()+":"+userdetail.getPassword()+":"+userdetail.getRole());
				}
		      
		//Update the Category
				UserDetail userdetail=userdetailDAO.getUserDetail("shreyas");
				category.setCatname("Dell with 1TB HardDisc ");
				categoryDAO.insertUpdateCategory(category);
				System.out.println("The Category Updated");*/
				
		
	}

}
