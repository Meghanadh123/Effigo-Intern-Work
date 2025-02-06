package com.example.MapstructDemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.MapstructDemo.DTO.EmployeeDTO;
import com.example.MapstructDemo.entity.Employee;

@Mapper
public interface EmployeePopulator {

	EmployeePopulator INSTANCE=Mappers.getMapper(EmployeePopulator.class);
	Employee popluateEmployee(EmployeeDTO employeeDTO);
}
