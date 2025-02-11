package com.employee.Backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.Backend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
