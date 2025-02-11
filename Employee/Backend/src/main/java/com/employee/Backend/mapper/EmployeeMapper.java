package com.employee.Backend.mapper;

import com.employee.Backend.dto.EmployeeDto;
import com.employee.Backend.entity.Employee;

public class EmployeeMapper {
	
	public static EmployeeDto mapToEmployeeDto(Employee employee) {
	    if (employee == null) return null;
	    return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
	}

	
	public static Employee mapToEmployee(EmployeeDto employeeDto)
	{
		return new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail()
				);
				
	}

}
