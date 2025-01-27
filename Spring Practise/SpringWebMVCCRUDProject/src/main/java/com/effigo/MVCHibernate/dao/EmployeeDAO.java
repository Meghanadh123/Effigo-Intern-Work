package com.effigo.MVCHibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.effigo.MVCHibernate.model.Employee;

@Repository
@Transactional
public interface EmployeeDAO 
{
  public String AddEmployee(Employee emp);
  public String UpdateEmployee(Employee emp);
  public String DeleteEmployee(int id);
  public List<Employee> ViewAllEmployees();
  public Employee ViewEmployeeById(int id);
  

}