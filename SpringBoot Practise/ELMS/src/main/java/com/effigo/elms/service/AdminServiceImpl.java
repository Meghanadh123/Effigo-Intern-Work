package com.effigo.elms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effigo.elms.model.Admin;
import com.effigo.elms.model.Employee;
import com.effigo.elms.model.HR;
import com.effigo.elms.model.Leave;
import com.effigo.elms.repository.AdminRepository;
import com.effigo.elms.repository.EmployeeRepository;
import com.effigo.elms.repository.HRRepository;
import com.effigo.elms.repository.LeaveRepository;

@Service

public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private LeaveRepository leaveRepository;

    @Autowired 
    private HRRepository hrRepository;

	
	
	@Override
	public List<Employee> viewallemps() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee viewempbyid(int eid) {
		Optional<Employee> obj =  employeeRepository.findById(eid);
        
        if(obj.isPresent())
        {
          Employee emp = obj.get();
          
          return emp;
        }
        else
        {
          return null;
        }
	}

	@Override
	public String deleteemp(int eid) {
		Optional<Employee> obj =  employeeRepository.findById(eid);
	       
	       String msg = null;
	       
	       if(obj.isPresent())
	       {
	         Employee emp = obj.get();
	         
	         employeeRepository.delete(emp);
	         
	         msg = "Employee Deleted Successfully";
	       }
	       else
	       {
	         msg = "Employee Not Found";
	       }
	       
	       return msg;
	}

	@Override
	public Admin checkadminlogin(String uname, String pwd) {
		return adminRepository.checkadminlogin(uname, pwd);
	}

	
	

	@Override
	public long employeecount() {
		return employeeRepository.count();
	}
	
	
	  @Override 
	  public long hcount() { 
		return hrRepository.count(); 
	}
	 

	//employee active status update
	@Override
	public int updatestatus(int eid, boolean status) {
		return adminRepository.updatestatus(eid, status);
	
		
	}

	@Override
	public List<Leave> viewallleaves() {
		return leaveRepository.findAll();
	}

	@Override
	public int updateleavestatus(int sno, boolean status) 
	{
		return adminRepository.updateleavestatus(sno, status);
		
	}

	@Override
	public List<Leave> approvedleaves() { 
		return adminRepository.approvedleaves();
	}

	@Override
	public List<Leave> rejectedleaves() {
		return adminRepository.rejectedleaves();
	}

	@Override
	public String addhr(HR h) 
	{
		hrRepository.save(h);
		return "HR Added Successfully";
	}


	@Override
	public List<HR> viewallhr() {
		return hrRepository.findAll();

    }


	@Override
	public HR viewhrbyid(int hid) {
		Optional<HR> obj =  hrRepository.findById(hid);
        
        if(obj.isPresent())
        {
          HR h = obj.get();
          
          return h;
        }
        else
        {
          return null;
        }
	}


	@Override
	public String deletehr(int hid) {
		Optional<HR> obj =  hrRepository.findById(hid);
	       
	       String msg = null;
	       
	       if(obj.isPresent())
	       {
	         HR hr = obj.get();
	         
	         hrRepository.delete(hr);
	         
	         msg = "HR Deleted Successfully";
	       }
	       else
	       {
	         msg = "HR Not Found";
	       }
	       
	       return msg;
	}
}
