package com.example.OneToOne;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OneToOne.entity.Employee;
import com.example.OneToOne.repo.EmployeeRepo;

@RestController
@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	
	@PostMapping("/saveEmp")
	public ResponseEntity<String> saveEmp(@RequestBody List<Employee> empData)
	{
		employeeRepo.saveAll(empData);
		return ResponseEntity.ok("Data Saved");
	}

}
