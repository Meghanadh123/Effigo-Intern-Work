package com.employee.Backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.Backend.dto.EmployeeDto;
import com.employee.Backend.entity.Employee;
import com.employee.Backend.exception.ResourceNotFoundException;
import com.employee.Backend.mapper.EmployeeMapper;
import com.employee.Backend.repo.EmployeeRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee=EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee=employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto getEmpById(Long employeeId) {
		Employee employee=employeeRepository.findById(employeeId)
		         .orElseThrow(()->new ResourceNotFoundException("Employee is not avaiable"+employeeId));
		return EmployeeMapper.mapToEmployeeDto(employee);
		
		
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
	List<Employee> employees=	employeeRepository.findAll();
	return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
							.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		Employee employee=employeeRepository.findById(employeeId)
		         .orElseThrow(()->new ResourceNotFoundException("Employee is not avaiable"+employeeId));
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		Employee updatedEmployeeObj=employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee=employeeRepository.findById(employeeId)
		         .orElseThrow(()->new ResourceNotFoundException("Employee is not avaiable"+employeeId));
		employeeRepository.deleteById(employeeId);
	}
	
	

}
