package com.effigo.MVCHibernate.service;

import java.util.List;

import com.effigo.MVCHibernate.dao.EmployeeDAO;
import com.effigo.MVCHibernate.model.Employee;

public class EmployeeServiceImpl  implements EmployeeService 
{

	private EmployeeDAO dao;
	public EmployeeDAO getDao() {
		return dao;
	}

	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public String AddEmployee(Employee emp) {
		
		return dao.AddEmployee(emp);
	}

	@Override
	public String UpdateEmployee(Employee emp) {
		
		return dao.UpdateEmployee(emp);
	}

	@Override
	public String DeleteEmployee(int id) {
		// TODO Auto-generated method stub
		return dao.DeleteEmployee(id);
	}

	@Override
	public List<Employee> ViewAllEmployees() {
		
		return dao.ViewAllEmployees();
	}

	@Override
	public Employee ViewEmployeeByID(int id) {
		
		return dao.ViewEmployeeById(id);
	}

}
