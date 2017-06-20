package com.niit.PlanetSportsBackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.PlanetSportsBackend.dao.CategoryDAO;
import com.niit.PlanetSportsBackend.dao.SupplierDAO;
import com.niit.PlanetSportsBackend.model.Category;
import com.niit.PlanetSportsBackend.model.Supplier;

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
		   System.out.println("-- CategoryDAO Object Creation--");
		   return new CategoryDAO(sessionFactory);
	   }
	   
	   @Autowired
	   @Bean(name="supplierDAO")
	   public SupplierDAO getSupplierDAO(SessionFactory sessionFactory)
	   {
        System.out.println("-----Supplier DAO object Creation------");
        return new SupplierDAO(sessionFactory);
		   
	   }
}


