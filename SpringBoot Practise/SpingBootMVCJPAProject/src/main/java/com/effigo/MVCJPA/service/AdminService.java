package com.effigo.MVCJPA.service;

import java.util.List;

import com.effigo.MVCJPA.model.Admin;
import com.effigo.MVCJPA.model.Customer;
import com.effigo.MVCJPA.model.Employee;

public interface AdminService {
	public List<Employee> viewallemps();
	public Employee viewempbyid(int eid);
	public String deleteemp(int eid);
	public Admin checkadminlogin(String uname,String pwd);
	
	//customer
		public String addcustomer(Customer c);
		public long employeecount();//count(*)
		public long customercount();//count(*)
		public int updatestatus(int eid, boolean status);
		
}
