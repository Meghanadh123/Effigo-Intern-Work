package com.effigo.hibernate;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HibernateCRUDOperations 
{
 public static void main(String args[])
 {
   HibernateCRUDOperations crudOperations = new HibernateCRUDOperations();
   crudOperations.insertstudent();
  // crudOperations.viewstudent();
   //crudOperations.deletestudent();
   //crudOperations.updatestudent();
 }
 public void insertstudent()
 {
   Configuration cfg=new Configuration();
   cfg.configure("hibernate.cfg.xml");
   
   SessionFactory sf=cfg.buildSessionFactory();
   Session session=sf.openSession();
   
   Student student= new Student();
   student.setId(101);
   student.setName("RAMA");
   student.setGender("MALE");
   student.setDateofbirth("12/10/1999");
   student.setDepartment("CSE");
   student.setCollege("SRM");
   student.setCgpa(9.8);
   student.setBacklogs(0);
   student.setContact("9177968335");
   
   Transaction t=session.beginTransaction();
   session.save(student);
   t.commit();
   System.out.println("Student Object Saved Successfully");
   
   session.close();
   sf.close();
   
 }
 public void updatestudent()
 {
	 Configuration cfg = new Configuration();
     cfg.configure("hibernate.cfg.xml");
     
     SessionFactory sf = cfg.buildSessionFactory();
     Session session = sf.openSession();
     
     Transaction t = session.beginTransaction();
     
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter Student ID");
     int sid = sc.nextInt();
     
     
     Student s = session.get(Student.class, sid);
     if(s!=null)
     {
       
       System.out.println("Enter Student CGPA");
         double scgpa = sc.nextDouble();
         System.out.println("Enter Student Backlogs");
         int sbacklogs = sc.nextInt();
         System.out.println("Enter Student Contact No");
         String scontact = sc.next();
       
         s.setCgpa(scgpa);
         s.setBacklogs(sbacklogs);
         s.setContact(scontact);
         
         t.commit();
         System.out.println("Student Object Updated Successfully");
     }
     else
     {
       System.out.println("Student Object Not Found");
     }
     
     sc.close();
     session.close();
     sf.close();
 }
 public void deletestudent()
 {
	 Configuration cfg = new Configuration();
     cfg.configure("hibernate.cfg.xml");
     
     SessionFactory sf = cfg.buildSessionFactory();
     Session session = sf.openSession();
     
     Transaction t = session.beginTransaction();
     
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter Student ID:");
     int sid = sc.nextInt();
     
  
     Student s = session.get(Student.class, sid);
     
       if(s!=null)
       {
         session.delete(s);
         t.commit();
         System.out.println("Student Object Deleted Successfully");
         
       }
       else
       {
         System.out.println("Student Object Not Found");
       }
     
     sc.close();
     session.close();
     sf.close();
 }
 public void viewstudent()
 {
	 Configuration cfg = new Configuration();
     cfg.configure("hibernate.cfg.xml");
     
     SessionFactory sf = cfg.buildSessionFactory();
     Session session = sf.openSession();
     
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter Student ID:");
     int sid = sc.nextInt();
     
     System.out.println("***Student Information**");
     
     Student s = session.load(Student.class, sid);
     
     
     
     System.out.println("Student ID:"+s.getId());
     System.out.println("Student NAME:"+s.getName());
     System.out.println("Student DOB:"+s.getDateofbirth());
     System.out.println("Student CGPA:"+s.getCgpa());
     System.out.println("Student Contact Number:"+s.getContact());
     
     sc.close();
     session.close();
     sf.close();
 }
}