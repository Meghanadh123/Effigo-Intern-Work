package com.effigo.MVCJPA.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effigo.MVCJPA.model.Employee;
import com.effigo.MVCJPA.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
  @Autowired
  private EmployeeRepository employeeRepository;
  @Override
  public String addemployee(Employee emp)
  {
    employeeRepository.save(emp);
    return "Employee Added Successfully";
  }

  @Override
  public String updateemployee(Employee emp) 
  {
    Employee e =employeeRepository.findById(emp.getId()).get();
    
    e.setName(emp.getName());
    e.setDateofbirth(emp.getDateofbirth());
    e.setDepartment(emp.getDepartment());
    e.setSalary(emp.getSalary());
    e.setEmail(emp.getEmail());
    e.setPassword(emp.getPassword());
    e.setLocation(emp.getLocation());
    e.setContact(emp.getContact());
   
    employeeRepository.save(e);
    
    return "Employee Updated Successfully";
  }

  @Override
  public Employee viewemployeebyid(int eid)
  {
    
    //return employeeRepository.findById(eid).get();
    //or
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
public Employee checkemplogin(String email, String pwd) {
	return employeeRepository.checkemplogin(email, pwd);
}

}