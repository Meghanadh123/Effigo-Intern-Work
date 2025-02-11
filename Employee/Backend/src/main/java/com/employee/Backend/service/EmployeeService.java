package com.employee.Backend.service;

import java.util.List;

import com.employee.Backend.dto.EmployeeDto;


public interface EmployeeService  {

	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto getEmpById(Long employeeId);
	List<EmployeeDto> getAllEmployees();
	EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);
	void deleteEmployee(Long employeeId);
	
	
}
