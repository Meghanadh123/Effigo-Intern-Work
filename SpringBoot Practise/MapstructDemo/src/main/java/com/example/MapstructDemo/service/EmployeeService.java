package com.example.MapstructDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.MapstructDemo.DTO.EmployeeDTO;
import com.example.MapstructDemo.entity.Employee;
import com.example.MapstructDemo.mapper.EmployeePopulator;
import com.example.MapstructDemo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	
	@Autowired 
	EmployeeRepository employeeRepository;
	
	
	public Employee saveEmp(EmployeeDTO employeeDTO)
	
	{
		Employee employee=EmployeePopulator.INSTANCE.popluateEmployee(employeeDTO);
		return employeeRepository.save(employee);
	}

}
 