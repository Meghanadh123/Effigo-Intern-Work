package com.effigo.RESTAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effigo.RESTAPI.model.Customer;
import com.effigo.RESTAPI.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService 
{
	@Autowired
    private CustomerRepository repository;
	
	@Override
	public String addcustomer(Customer customer)
	{
		repository.save(customer);
		return "Customer Added Successfully";
	}

	@Override
	public String updatecustomer(Customer customer) {
		Optional<Customer> obj =  repository.findById(customer.getId());
	    
	    String msg = null;
	    
	    if(obj.isPresent())
	    {
	      Customer c = obj.get();
	      
	      c.setName(customer.getName());
	      c.setSalary(customer.getSalary());
	      
	      repository.save(c);
	      
	      msg = "Customer Updated Successfully";
	    }
	    else
	    {
	      msg = "Customer ID Not Found";
	    }
	    
	    return msg;
	}

	@Override
	public String deleteemployee(int id) 
	{
		Optional<Customer> obj =  repository.findById(id);
	       
	       String msg = null;
	       
	       if(obj.isPresent())
	       {
	         Customer c = obj.get();
	         
	         repository.delete(c);
	         
	         msg = "Customer Deleted Successfully";
	       }
	       else
	       {
	         msg = "Customer ID Not Found";
	       }
	       
	       return msg;
	}

	@Override
	public List<Customer> viewallcustomers() 
	{
		List<Customer> customerList = (List<Customer>) repository.findAll();
		
		return customerList;
	}

	@Override
	public Customer viewcustomerbyid(int id) 
	{
		Customer c = repository.findById(id).get();
		
		return c;
	}
  
}
