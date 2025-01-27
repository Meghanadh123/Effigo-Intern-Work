package com.effigo.MVCJPA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effigo.MVCJPA.model.Admin;
import com.effigo.MVCJPA.model.Customer;
import com.effigo.MVCJPA.model.Employee;
import com.effigo.MVCJPA.repository.AdminRepository;
import com.effigo.MVCJPA.repository.CustomerRepository;
import com.effigo.MVCJPA.repository.EmployeeRepository;

@Service

public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public List<Employee> viewallemps() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee viewempbyid(int eid) {
		Optional<Employee> obj =  employeeRepository.findById(eid);
        
        if(obj.isPresent())
        {
          Employee emp = obj.get();
          
          return emp;
        }
        else
        {
          return null;
        }
	}

	@Override
	public String deleteemp(int eid) {
		Optional<Employee> obj =  employeeRepository.findById(eid);
	       
	       String msg = null;
	       
	       if(obj.isPresent())
	       {
	         Employee emp = obj.get();
	         
	         employeeRepository.delete(emp);
	         
	         msg = "Employee Deleted Successfully";
	       }
	       else
	       {
	         msg = "Employee Not Found";
	       }
	       
	       return msg;
	}

	@Override
	public Admin checkadminlogin(String uname, String pwd) {
		return adminRepository.checkadminlogin(uname, pwd);
	}

	@Override
	public String addcustomer(Customer c) {
		customerRepository.save(c);
		 return "Customer Added Successfully"; 
	}

	@Override
	public long employeecount() {
		return employeeRepository.count();
	}

	@Override
	public long customercount() {
		return customerRepository.count();
	}

	//employee active status update
	@Override
	public int updatestatus(int eid, boolean status) {
		return adminRepository.updatestatus(eid, status);
	
		
	}

}
