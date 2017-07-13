package com.niit.PlanetSportsBackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.PlanetSportsBackend.model.Category;
import com.niit.PlanetSportsBackend.model.UserDetail;

@Repository("userdetailDAO")
public class UserDetailDAO 
{
	@Autowired
	SessionFactory sessionFactory;
     
	public UserDetailDAO(SessionFactory sessionFactory)
	{
       this.sessionFactory=sessionFactory;
	}
	
    @Transactional
	public void insertUpdateUserDetail(UserDetail userdetail)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(userdetail);
	}
    public UserDetail getUserDetail(String username)
    {

    	Session session= sessionFactory.openSession();
    	UserDetail userdetail=(UserDetail)session.get(UserDetail.class,username);
    	session.close();
    	return userdetail;
    }
    
   /* //Adding Address
     public boolean addAddress(Address address)
     {

 		try{

 			Session session=sessionFactory.getCurrentSession();
 			session.saveOrUpdate(address);
 			return true;
 		  }
 		
 		catch(Exception e)
 		{
 			 e.printStackTrace();
     	     return false;
 		}
    	 
     }
     
    
     //Adding Cart
    public boolean addCart(Cart cart)
    {
		try{

			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(cart);
			return true;
		  }
		
		catch(Exception e)
		{
			 e.printStackTrace();
    	     return false;
		}
    }
    
    public List<Address> listShippingAddresses(UserDetail userdetail)
    {
    	String selectQuery = "FROM Address WHERE userdetail = :userdetail AND shipping = :shipping";
    	try{
    		 return sessionFactory.getCurrentSession()
    				 .createQuery(selectQuery, Address.class)
    				 .setParameter("userdetail", userdetail)
    				 .setParameter("shipping",true)
    				 .list();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return null;
    	}
    }
    
    
    */
	public List<UserDetail> getUserDetailDetails()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserDetail");
		List<UserDetail> list=query.list();
		session.close();
		return list;
	}
}
