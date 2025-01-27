package com.effigo.elms.service;

import java.util.List;

import com.effigo.elms.model.Employee;
import com.effigo.elms.model.Leave;
public interface EmployeeService {
	public String addemployee(Employee emp);
	public String updateemployee(Employee emp);
	public Employee viewemployeebyid(int eid);
	public Employee checkemplogin(String email,String pwd);
	public String applyleave(Leave leave);
	public List<Leave> employeeappliedleaves(String name);
	
	
	
	
	
	
}
