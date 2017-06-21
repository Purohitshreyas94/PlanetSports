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
	public void insertUpdateCategory(UserDetail userdetail)
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
    
    
    @Transactional
	public void deleteUserDetail(UserDetail userdetail)
	{
		sessionFactory.getCurrentSession().delete(userdetail);
	}
	
  
	public List<UserDetail> getUserDetailDetails()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserDetail");
		List<UserDetail> list=query.list();
		session.close();
		return list;
	}
}
