package com.effigo.hibernate.HQL;
import org.hibernate.*;
import org.hibernate.cfg.*;

import org.hibernate.query.Query;

import java.util.*;

public class HQLDemo {
	public static void main(String args[])
	{
		HQLDemo demo=new HQLDemo();
		//demo.insertcustomer();
		//demo.viewallcustomerscompleteobject();
		demo.viewallcustomerspartialobject();
		//demo.aggregatefunctions();
		//demo.updatepositionalparams();
		//demo.deletepositionalparams();
		//demo.updatenamedparameters();
		//demo.deletepositionalparams();
		//demo.deletenamedparameters();
		//demo.viewcustomerbyidpositionalparams();
		//demo.viewcustomerbyidnameparams();
	}
	public void insertcustomer()
	{
		Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	        
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session session = sf.openSession();
	          
	    Customer customer = new Customer();
	    customer.setId(104);
	    customer.setName("Virag");
	    customer.setGender("MALE");
	    customer.setAge(34.5f);
	    customer.setSalary(13500.0);
	    customer.setEmail("virag@gmail.com");
	    customer.setPassword("virag");
	    customer.setContact("9090909099");
	    customer.setMaritalstatus(true);
	    
	    Transaction t = session.beginTransaction();
	    session.save(customer);
	    t.commit();
	    
	    System.out.println("Customer Object Saved Successfully");
	    
	    session.close();
	    sf.close();
	}
	public void viewallcustomerscompleteobject() //Complete Object
	{
		Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	        
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session session = sf.openSession();
	    
	    Query qry=session.createQuery("from Customer");
	    
	    List<Customer>clist=  qry.getResultList();
	    
	    System.out.println("**Customer Information**");
	    System.out.println("Total Customers"+clist.size());
	    
	    for(Customer c:clist)
	    {
	    	System.out.println(c.toString());
	    }
	    session.close();
	    sf.close();
	    
	}
	public void viewallcustomerspartialobject() //partial object
	{
		Configuration cfg = new Configuration();
	     cfg.configure("hibernate.cfg.xml");
	          
	     SessionFactory sf = cfg.buildSessionFactory();
	     Session session = sf.openSession();
	    
	       Query qry = session.createQuery(" select c.id,c.name,c.age,c.salary from Customer c ");
	     //c is reference object or alias of type Customer
	 
	       List<Object[]> clist =  qry.getResultList();
	       System.out.println("****Customer Information****");
	       System.out.println("Total Customers="+clist.size());

	       for(Object[] obj:clist)
	       {
	         System.out.println("Customer ID:"+obj[0]);
	         System.out.println("Customer Name:"+obj[1]);
	         System.out.println("Customer Age:"+obj[2]);
	         System.out.println("Customer Salary:"+obj[3]);
	         
	         System.out.println();
	       }
	       
	     
	      session.close();
	      sf.close();	    
	    
	}
	public void aggregatefunctions()
	{
		Configuration cfg = new Configuration();
	     cfg.configure("hibernate.cfg.xml"); 
	     SessionFactory sf = cfg.buildSessionFactory();
	     Session session = sf.openSession();
	     
	     Query qry1=session.createQuery("select count(*) from Customer");
	     List list1=qry1.list();
	    System.out.println("***count(*)***");
	    System.out.println("Total customers="+list1.get(0));
	    
	    Query qry2=session.createQuery("select min(age) from Customer");
	     List list2=qry2.list();
	    System.out.println("*** min(age) ***");
	    System.out.println("customers minimum age="+list2.get(0));
	    
	    Query qry3=session.createQuery("select max(age) from Customer");
	     List list3=qry3.list();
	    System.out.println("***max(age)***");
	    System.out.println("customers maximum age="+list3.get(0));
	    
	    Query qry4=session.createQuery("select sum(salary) from Customer");
	     List list4=qry4.list();
	    System.out.println("***sum(salary)***");
	    System.out.println("customer's Total salary="+list4.get(0));
	    
	    Query qry5=session.createQuery("select avg(salary) from Customer");
	     List list5=qry5.list();
	    System.out.println("***avg(salary)***");
	    System.out.println("customers Average salary="+list5.get(0));
	     
	    
	    
	    session.close();
	      sf.close();
   
	     
	}

	public void updatepositionalparams()
	{
		Configuration cfg = new Configuration();
	     cfg.configure("hibernate.cfg.xml");
	          
	     SessionFactory sf = cfg.buildSessionFactory();
	     Session session = sf.openSession();
	     
	     Transaction t = session.beginTransaction();
	     
	     int cid=105;
	     float cage=32.5f; 
	     double csalary=56000.70;
	     String contact="9890909096";
	     
	    Query qry = session.createQuery(" update Customer set age=?1,salary=?2,contact=?3 where id=?4 ");
	    qry.setFloat(1, cage);
	    qry.setDouble(2, csalary);
	    qry.setString(3, contact);
	    qry.setInteger(4, cid);
	       
	    int n = qry.executeUpdate(); 
	  
	    
	    if(n>0)
	    {
	      System.out.println(n+" Record(s) Updated Successfully ");
	    }
	    else
	    {
	      System.out.println("Customer ID Not Found");
	    }
	    
	    t.commit();
	    session.close();
	    sf.close();	
	}
	public void deletepositionalparams()
	  {
	    Configuration cfg = new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	            
	       SessionFactory sf = cfg.buildSessionFactory();
	       Session session = sf.openSession();
	       
	       Transaction t = session.beginTransaction();
	       
	       Scanner s=new Scanner(System.in);
	       System.out.println("Enter Customer id:");
	       int cid=s.nextInt();
	       
	       Query qry=session.createQuery("delete from Customer where id=?1 ");
	       qry.setInteger(1, cid);
	       
	       
	       int n = qry.executeUpdate(); 
	      
	        
	        if(n>0)
	        {
	          System.out.println(n+" Record(s) Deleted Successfully ");
	        }
	        else
	        {
	          System.out.println("Customer ID Not Found");
	        }
	        
	        t.commit();
	        session.close();
	        sf.close();
	  }

	public void updatenamedparameters()
	{
		Configuration cfg = new Configuration();
	     cfg.configure("hibernate.cfg.xml");
	          
	     SessionFactory sf = cfg.buildSessionFactory();
	     Session session = sf.openSession();
	     
	     Transaction t = session.beginTransaction();
	     
	     int cid=104;
	     float cage=40.0f;
	     double csalary=25000.00;
	    
	     
	    Query qry = session.createQuery(" update Customer set age=:v1 ,salary=:v2 where id=:v3");
	    
	      qry.setParameter("v1",cage);
	      qry.setParameter("v2",csalary);
	      qry.setParameter("v3",cid);
	    int n = qry.executeUpdate(); 
	  
	    
	    if(n>0)
	    {
	      System.out.println(n+" Record(s) Updated Successfully ");
	    }
	    else
	    {
	      System.out.println("Customer ID Not Found");
	    }
	    
	    t.commit();
	    session.close();
	    sf.close();	
	}
	
	public void deletenamedparameters()
	{
		 Configuration cfg = new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	            
	       SessionFactory sf = cfg.buildSessionFactory();
	       Session session = sf.openSession();
	       
	       Transaction t = session.beginTransaction();
	       
	       Scanner s=new Scanner(System.in);
	       System.out.println("Enter Customer id:");
	       int cid=s.nextInt();
	       
	       Query qry=session.createQuery("delete from Customer where id=:v ");
	       qry.setParameter("v",cid);
	       
	       
	       int n = qry.executeUpdate(); 
	      
	        
	        if(n>0)
	        {
	          System.out.println(n+" Record(s) Deleted Successfully ");
	        }
	        else
	        {
	          System.out.println("Customer ID Not Found");
	        }
	        
	        t.commit();
	        session.close();
	        sf.close();
	}
	
	public void viewcustomerbyidpositionalparams()
	{
		Configuration cfg = new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	            
	       SessionFactory sf = cfg.buildSessionFactory();
	       Session session = sf.openSession();
	       
	       Scanner sc=new Scanner(System.in);
	       System.out.println("Enter Customer id: ");
	       int cid=sc.nextInt();
	       Query qry=session.createQuery("from Customer where id=?1 ");
	       qry.setInteger(1, cid);
	       
	      // Customer c=(Customer)qry.getSingleResult();
	       
	       List<Customer>clist=qry.list();
	       System.out.println("***View Customer By ID***");
	       
	       if(clist.size()>0)
	       {
	    	 System.out.println(clist.get(0).toString());  //clist contains only one object
	       }
	       else
	       {
	    	   System.out.println("Customer Id not Found");
	       }
	      
	       session.close();
	       sf.close();
	}
	public void viewcustomerbyidnameparams()
	{
		Configuration cfg = new Configuration();
	       cfg.configure("hibernate.cfg.xml");
	            
	       SessionFactory sf = cfg.buildSessionFactory();
	       Session session = sf.openSession();
	       
	       Scanner sc=new Scanner(System.in);
	       System.out.println("Enter Customer id: ");
	       int cid=sc.nextInt();
	       Query qry=session.createQuery("from Customer where id=:v ");
	       qry.setParameter("v",cid);
	       
	      // Customer c=(Customer)qry.getSingleResult();
	       
	       List<Customer>clist=qry.list();
	       System.out.println("***View Customer By ID***");
	       
	       if(clist.size()>0)
	       {
	    	 System.out.println(clist.get(0).toString());  //clist contains only one object
	       }
	       else
	       {
	    	   System.out.println("Customer Id not Found");
	       }
	      
	       session.close();
	       sf.close();
	}

}
