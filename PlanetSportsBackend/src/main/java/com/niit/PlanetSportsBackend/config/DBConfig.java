package com.niit.PlanetSportsBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.niit.PlanetSportsBackend.dao.CategoryDAO;
import com.niit.PlanetSportsBackend.dao.SupplierDAO;
import com.niit.PlanetSportsBackend.dao.UserDetailDAO;
import com.niit.PlanetSportsBackend.dao.ProductDAO;


import com.niit.PlanetSportsBackend.model.Category;
import com.niit.PlanetSportsBackend.model.Product;
import com.niit.PlanetSportsBackend.model.Supplier;
import com.niit.PlanetSportsBackend.model.UserDetail;

@Configuration
@ComponentScan("com.niit.PlanetSportsBackend")
@EnableTransactionManagement

public class DBConfig 
{
	@Bean(name="dataSource")
	  public DataSource getH2DataSource()
	  {
         System.out.println("----Data Source Creation-----");
		   DriverManagerDataSource dataSource = new DriverManagerDataSource();
		   dataSource.setDriverClassName("org.h2.Driver");
		   dataSource.setUrl("jdbc:h2:tcp://localhost/~/DtProject");
		   dataSource.setUsername("Admin");
		   dataSource.setPassword("admin");
		   System.out.println("----Data Source Creation-----");
		   return dataSource;
	  }
	   @Autowired
	   @Bean(name="sessionFactory")
	   public SessionFactory getSessionFactory(DataSource dataSource)
	   {
         System.out.println("------Hibernate properties creation------");
		   Properties properties=new Properties();
		   properties.setProperty("hibernate.hbm2ddl.auto", "update");
		   properties.put("hibernate.show_sql", "true");
		   properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		   System.out.println("------Hibernate properties created------");
		   
		   System.out.println("------LacalSessionFactoryBuider object creation------");
		   LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(getH2DataSource());
		   sessionBuilder.addProperties(properties);
		   System.out.println("------Factory Builder object created------");
		   sessionBuilder.addAnnotatedClass(Category.class);
		   sessionBuilder.addAnnotatedClass(Supplier.class);
		   sessionBuilder.addAnnotatedClass(Product.class);
		   sessionBuilder.addAnnotatedClass(UserDetail.class);
		  // sessionBuilder.addAnnotatedClass(Cart.class);
		   System.out.println("------Session Factory  object creation------");
		   SessionFactory sessionFactory=sessionBuilder.buildSessionFactory();
		   System.out.println("------Session factory object created------");
		   return sessionFactory;
		   //return sessionBuilder.buildSessionFactory();
	   }
	   
	   
     @Autowired
	   @Bean(name="transactionManager")
	   public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	   {

		   HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
				   return transactionManager;
	   }
     
    
	   @Autowired
	   @Bean(name="categoryDAO")
	   public CategoryDAO getCategoryDAO(SessionFactory sessionFactory)
	   {
		   System.out.println("-- Category DAO Object Creation--");
		   return new CategoryDAO(sessionFactory);
	   }
	   
	  @Autowired
	   @Bean(name="supplierDAO")
	   public SupplierDAO getSupplierDAO(SessionFactory sessionFactory)
	   {
        System.out.println("-----Supplier DAO object Creation------");
        return new SupplierDAO(sessionFactory);
		   
	   }
	   @Autowired
	   @Bean(name="productDAO")
	   public ProductDAO getProductDAO(SessionFactory sessionFactory)
	   {
        System.out.println("-----Product DAO object Creation------");
        return new ProductDAO(sessionFactory);
		   
	   }
	  
	   @Autowired
	   @Bean(name="userdetailDAO")
	   public UserDetailDAO getUserDetailDAO(SessionFactory sessionFactory)
	   {
        System.out.println("-----User DAO object Creation------");
        return new UserDetailDAO(sessionFactory);
		   
	   }
	/*   @Autowired
	   @Bean(name="cartDAO")
	   public CartDAO getCartDAO(SessionFactory sessionFactory)
	   {
        System.out.println("-----Cart DAO object Creation------");
		return new CartDAO(sessionFactory);
       
	   }*/	   
}


