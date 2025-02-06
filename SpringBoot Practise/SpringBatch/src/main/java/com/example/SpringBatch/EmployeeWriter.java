package com.example.SpringBatch;

import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.SpringBatch.entity.Employee;
import com.example.SpringBatch.repo.EmployeeRepository;

public class EmployeeWriter implements ItemWriter<Employee> {
	
	@Autowired
	private EmployeeRepository  employeeRepository;

	@Override
	public void write(Chunk<? extends Employee> chunk) throws Exception {
		System.out.println("Thread Name:"+Thread.currentThread().getName());
	    employeeRepository.saveAll(chunk.getItems());
	}

}
