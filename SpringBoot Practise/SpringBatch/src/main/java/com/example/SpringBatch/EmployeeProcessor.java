package com.example.SpringBatch;

import org.springframework.batch.item.ItemProcessor;

import com.example.SpringBatch.entity.Employee;

public class EmployeeProcessor implements ItemProcessor<Employee, Employee>{//input and output 
	
	
	public Employee process(Employee employee) throws Exception{
		long salary=employee.getSalary();
		if(salary>=50000)
		{
			return employee;
			
		}
		return null;
	}

}
