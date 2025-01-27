package com.effigo.MVCJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.effigo.MVCJPA.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer , Integer> {

}
