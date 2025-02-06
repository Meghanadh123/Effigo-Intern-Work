package com.example.OneToOne.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OneToOne.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	

}
