package com.effigo.elms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effigo.elms.model.Employee;
import com.effigo.elms.model.HR;
import com.effigo.elms.model.Leave;
import com.effigo.elms.repository.EmployeeRepository;
import com.effigo.elms.repository.HRRepository;
import com.effigo.elms.repository.LeaveRepository;


@Service
public class HRServiceImpl  implements HRService
{
	 @Autowired
	  private HRRepository hrRepository;
	  @Autowired
	  private LeaveRepository leaveRepository;
	  
	  @Autowired
	  private EmployeeRepository employeeRepository;
	
//	  public String addhr(HR hr)
//	  {
//	    hrRepository.save(hr);
//	    return "HR Added Successfully";
//	  }
//
	  @Override
	  public String updatehr(HR h) 
	  {
	    HR hr =hrRepository.findById(h.getId()).get();
	    
	    h.setName(h.getName());
	    h.setDateofbirth(h.getDateofbirth());
	    h.setSalary(h.getSalary());
	    h.setEmail(h.getEmail());
	    h.setPassword(h.getPassword());
	    h.setLocation(h.getLocation());
	    h.setContact(h.getContact());
	
	    hrRepository.save(h);
	    
	    return "HR Updated Successfully";
	  }
	  
	  
	  @Override
	  public HR viewhrbyid(int hid)
	  {
	    
	    //return employeeRepository.findById(hid).get();
	    //or
	    Optional<HR> obj =  hrRepository.findById(hid);
	         
	         if(obj.isPresent())
	         {
	           HR hr = obj.get();
	           
	           return hr;
	         }
	         else
	         {
	           return null;
	         }
	  }

	  @Override 
	  public HR checkhrlogin(String email, String password) {
	  	return hrRepository.checkhrlogin(email, password);
	  }

	  @Override
	  public String applyleave(Leave leave) 
	  {
	  	leaveRepository.save(leave);
	      return "Applied";

	  }


	@Override
	public List<Leave> hrleavestatus(String name) {
		return hrRepository.hrleavestatus(name);
	}


	@Override
	public String deleteempbyhr(int hid) {
		Optional<Employee> obj =  employeeRepository.findById(hid);
	       
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

}
