package com.effigo.RESTAPI.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.effigo.RESTAPI.model.Customer;

public interface CustomerService 
{
	public String addcustomer(Customer customer);
	public String updatecustomer(Customer customer);
	public String deleteemployee(int id);
	public List<Customer> viewallcustomers();
	public Customer viewcustomerbyid(int id);
}
