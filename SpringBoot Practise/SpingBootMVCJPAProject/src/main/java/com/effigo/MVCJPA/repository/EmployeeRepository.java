package com.effigo.MVCJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.effigo.MVCJPA.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("select e from Employee e where e.email=?1 and e.password=?2")
	public Employee checkemplogin(String name , String pwd);
	
}
