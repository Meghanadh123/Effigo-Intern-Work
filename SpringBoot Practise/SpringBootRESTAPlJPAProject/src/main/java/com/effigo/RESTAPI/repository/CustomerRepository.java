package com.effigo.RESTAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.effigo.RESTAPI.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>
{
	

}
