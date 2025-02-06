package com.example.MapstructDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MapstructDemo.DTO.EmployeeDTO;
import com.example.MapstructDemo.entity.Employee;
import com.example.MapstructDemo.service.EmployeeService;

@RestController
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
    return new ResponseEntity<>	(service.saveEmp(employeeDTO),HttpStatus.CREATED);
    }

}
