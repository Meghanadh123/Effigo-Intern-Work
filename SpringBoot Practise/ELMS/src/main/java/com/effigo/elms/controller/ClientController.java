package com.effigo.elms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.effigo.elms.model.Admin;
import com.effigo.elms.model.EmailManager;
import com.effigo.elms.model.Employee;
import com.effigo.elms.model.HR;
import com.effigo.elms.model.Leave;
import com.effigo.elms.service.AdminService;
import com.effigo.elms.service.EmployeeService;
import com.effigo.elms.service.HRService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class ClientController 
{
  @Autowired AdminService adminService;
  
  @Autowired
  private EmployeeService employeeService;
  
  @Autowired
  private HRService hrService;
 
  @Autowired
  private EmailManager em;
  
  @GetMapping("/")
  public String main()
  {
    return "index";
  }
  
  @GetMapping("empreg")
  public ModelAndView empregistration()
  {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("empreg");
    return mv;
  }
  
  @GetMapping("emplogin") //URI & method name can be different
  public ModelAndView emplogin()
  {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("emplogin");
    return mv;
  }
  
  @PostMapping("checkemplogin")
  public ModelAndView checkemplogin(HttpServletRequest request)
  {
    
    String email = request.getParameter("email");
    String pwd = request.getParameter("pwd");
    
    Employee emp = employeeService.checkemplogin(email, pwd);
    
    ModelAndView mv = new ModelAndView();
    
    if(emp!=null)
    {
      //session
      
      HttpSession session = request.getSession();
      
      session.setAttribute("eid",emp.getId()); // eid is a session variable
      session.setAttribute("ename", emp.getName()); //ename is a session variable
      
      //session
      
      mv.setViewName("emphome");
    }
    else
    {
      mv.setViewName("emplogin");
      mv.addObject("message", "Login Failed");
    }
    
    return mv;
  }
  
  @GetMapping("emphome")
     public ModelAndView emphome(HttpServletRequest request)
     {
       ModelAndView mv = new ModelAndView();
       mv.setViewName("emphome");
       
       HttpSession session = request.getSession();
       
       int eid = (int)session.getAttribute("eid"); //eid is a session variable
       String ename = (String)session.getAttribute("ename"); //ename is a session variable
       
       mv.addObject("eid", eid);
       mv.addObject("ename", ename);
       
       return mv;
     }
  
  @GetMapping("adminlogin")
  public ModelAndView adminlogin()
  {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("adminlogin");
    return mv;
  }
  
  @PostMapping("checkadminlogin")
  public ModelAndView checkadminlogin(HttpServletRequest request)
  {
    String uname = request.getParameter("uname");
    String pwd = request.getParameter("pwd");
    
    Admin a = adminService.checkadminlogin(uname, pwd);
    
    ModelAndView mv = new ModelAndView();
    
    if(a!=null)
    {  
      mv.setViewName("adminhome");  
      long empcount=adminService.employeecount();
		
		  mv.setViewName("adminhome"); long hrcount=adminService.hcount();
		  mv.addObject("hcount", hrcount);
		 
      
    }
    else
    {
      mv.setViewName("adminlogin");
      mv.addObject("message", "Login Failed");
    }
    
    return mv;
  }
  
  @GetMapping("viewallemps")
  public ModelAndView viewallemps()
  {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("viewallemps");
    
    List<Employee> emplist = adminService.viewallemps();
    mv.addObject("empdata", emplist);
    
    return mv;
  }
  
	 @GetMapping("viewallhr")
	 public ModelAndView viewallhr() { 
	  ModelAndView mv = new ModelAndView();
	  mv.setViewName("viewallhr");
	  List<HR> hrlist = adminService.viewallhr(); 
	  mv.addObject("hrdata", hrlist);
	  return mv; 
	 }
	 
	 @GetMapping("viewhr")
	   public ModelAndView viewhrdemo(@RequestParam("id") int hid)
	   {
	     HR hr = adminService.viewhrbyid(hid);
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("viewhrbyid");
	     mv.addObject("hr", hr);
	     return mv;
	   }
	 
	 
  @GetMapping("viewallleaves")
  public ModelAndView viewallleaves()
  {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("viewallleaves");
    List<Leave> leavelist = adminService.viewallleaves();
    mv.addObject("leavedata", leavelist);
    
    return mv;
  }
  
  @GetMapping("setleavestatus")
  public ModelAndView setleavestatus(@RequestParam("id") int id,@RequestParam("status") boolean status)
  {
    int n=adminService.updateleavestatus(id, status);
    
    ModelAndView mv = new ModelAndView();
    mv.setViewName("viewallleaves");
    List<Leave> leavelist = adminService.viewallleaves();
    mv.addObject("leavedata", leavelist);
    
    if(n>0)
    {
      mv.addObject("message","Status updated Successfully");
    }
    else
    {
      mv.addObject("message","Failed to add");
    }
    return mv;
  }
  
  @PostMapping("insertemp")
  public ModelAndView insertaction(HttpServletRequest request)
  {
    ModelAndView mv = new ModelAndView();
    String msg = null;
    
    try 
    {
      String name = request.getParameter("name");
      String gender = request.getParameter("gender");
      String dob = request.getParameter("dob");
      String dept = request.getParameter("dept");
      String sal = request.getParameter("salary");
      double salary = Double.parseDouble(sal);
      String email = request.getParameter("email");
      String pwd = request.getParameter("pwd");
      String location = request.getParameter("location");
      String contact = request.getParameter("contact");
      
      Employee emp = new Employee();
          emp.setName(name);
          emp.setGender(gender);
          emp.setDateofbirth(dob);
          emp.setDepartment(dept);
          emp.setSalary(salary);
          emp.setEmail(email);
          emp.setPassword(pwd);
          emp.setLocation(location);
          emp.setContact(contact);
          emp.setActive(true);
          
          msg = employeeService.addemployee(emp);
          
          mv.setViewName("displaymsg");
          mv.addObject("message", msg);
          
    }
    catch(Exception e) 
    {
      mv.setViewName("displayerror");
      
      msg = e.getMessage();
      mv.addObject("message", msg);
    }
    return mv;
  }
  
  @GetMapping("adminhome")
     public ModelAndView adminhome()
     {
    long empcount=adminService.employeecount();
//    long hrcount=adminService.hrcount();

    
       ModelAndView mv = new ModelAndView();
       mv.setViewName("adminhome");
       mv.addObject("ecount", empcount);
//       mv.addObject("hcount", hrcount);

       return mv;
     }
  
  
  @GetMapping("view")
     public ModelAndView viewempdemo(@RequestParam("id") int eid)
     {
       Employee emp = adminService.viewempbyid(eid);
       ModelAndView mv = new ModelAndView();
       mv.setViewName("viewempbyid");
       mv.addObject("emp", emp);
       return mv;
       
     }
  
  @GetMapping("deleteemp")
     public ModelAndView deleteemp()
     {
       ModelAndView mv = new ModelAndView();
       mv.setViewName("deleteemp");
       
       List<Employee> emplist =  adminService.viewallemps();
       
       mv.addObject("empdata", emplist);
       
       return mv;
     }
  
  @GetMapping("delete/{id}")
  public String deleteaction(@PathVariable("id") int eid)
  {
    adminService.deleteemp(eid);
    return "redirect:/deleteemp";
  }
  
  @GetMapping("updateprofile")
     public ModelAndView updateemp(HttpServletRequest request)
     {
       ModelAndView mv = new ModelAndView();
       
       HttpSession session = request.getSession();
       
       mv.setViewName("updateprofile");
       
       mv.addObject("eid", session.getAttribute("eid"));
       mv.addObject("ename", session.getAttribute("ename"));
       
       int id = (int) session.getAttribute("eid");
       
       Employee emp = employeeService.viewemployeebyid(id);
       
       mv.addObject("emp", emp);
       
       return mv;
     }
     
     @PostMapping("update")
     public ModelAndView updateaction(HttpServletRequest request)
     {
       String msg = null;
       
       ModelAndView mv = new ModelAndView();
       
         HttpSession session = request.getSession();
       
       mv.addObject("eid", session.getAttribute("eid"));
       mv.addObject("ename", session.getAttribute("ename"));
       
       int id = (int) session.getAttribute("eid");
       
      try
      {
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String dept = request.getParameter("dept");
        String sal = request.getParameter("salary");
        double salary = Double.parseDouble(sal);
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String location = request.getParameter("location");
        String contact = request.getParameter("contact");
        Employee emp = new Employee();
        emp.setId(id);
        emp.setName(name);
        emp.setDateofbirth(dob);
        emp.setDepartment(dept);
        emp.setSalary(salary);
        emp.setEmail(email);
        emp.setPassword(pwd);
        emp.setLocation(location);
        emp.setContact(contact);
        
        
        msg = employeeService.updateemployee(emp);
        
        mv.setViewName("emplogin");
        mv.addObject("message",msg);
       
     }
     catch(Exception e)
     {
       msg = e.getMessage();
       
       mv.setViewName("updateerror");
        mv.addObject("message",msg);
     }
      
     
      return mv;

    }
    
   
   
    @GetMapping("updatestatus")
    public ModelAndView updatestatus()
    {
      ModelAndView mv = new ModelAndView();
         mv.setViewName("updatestatus");
         
         List<Employee> emplist = adminService.viewallemps();
         mv.addObject("empdata", emplist);
         
         return mv;
    }
 
    @GetMapping("updatestatushr")
    public ModelAndView updatestatushr()
    {
      ModelAndView mv = new ModelAndView();
         mv.setViewName("updatestatushr");
         
         List<HR> hrlist = adminService.viewallhr();
         mv.addObject("hrdata", hrlist);
         
         return mv;
    }
    
    
    @GetMapping("setstatus")
    public ModelAndView setstatusaction(@RequestParam("id") int eid, @RequestParam("status") boolean status)
    {
      int n=adminService.updatestatus(eid, status);
      ModelAndView mv = new ModelAndView();
      mv.setViewName("updatestatus");
      List<Employee> emplist = adminService.viewallemps();
      mv.addObject("empdata", emplist);
      if(n>0)
      {
        mv.addObject("message", "Status Updated Successfully");
      }else {
        mv.addObject("message", "Failed to Update Status");
      }
      
   return  mv ;
      
    }
    
    @GetMapping("emplogout")
    public ModelAndView emplogout()
    {
      ModelAndView mv = new ModelAndView();
      mv.setViewName("emplogin");
      mv.addObject("message", "Logout Successfully");
      return mv;
    }
    
    
    @GetMapping("applyleave")
    public ModelAndView applyleave(HttpServletRequest request)
    {
      ModelAndView mv = new ModelAndView();
      mv.setViewName("applyleave");
      HttpSession session = request.getSession();
      
      mv.addObject("eid", session.getAttribute("eid"));
      mv.addObject("ename", session.getAttribute("ename"));
     
      
      return mv;
    }
    @PostMapping("insertleave")
    public ModelAndView insertleave(HttpServletRequest request)
    {
      ModelAndView mv = new ModelAndView();
        String msg = null;
        HttpSession session = request.getSession(); 
        try
        {
          
          String name=(String)session.getAttribute("ename");
          
          int empid=Integer.parseInt(request.getParameter("empid"));
          String fromd = request.getParameter("fromd");
          String tod = request.getParameter("tod");
          String leavetype = request.getParameter("leavetype");
          Leave leave =new Leave();
          
          //leave.setId(id);
          leave.setLname(name);
          leave.setEmpid(empid);
          leave.setFromdate(fromd);
          leave.setTodate(tod);
          leave.setLeavetype(leavetype);
          msg = employeeService.applyleave(leave);
          msg = employeeService.applyleave(leave);
              mv.setViewName("displaymsg");
              
  
            mv.addObject("ename", session.getAttribute("ename"));
              mv.addObject("message", msg);
           
        }
        catch(Exception e) 
        {
           mv.setViewName("displayerror");
             
             msg = e.getMessage();
             mv.addObject("message", msg);
        }
        return mv;
    }
    @GetMapping("approvedleaves")
    public ModelAndView approvedleaves()
    {
      ModelAndView mv = new ModelAndView();
      mv.setViewName("approvedleaves");
      List<Leave> leavelist = adminService.approvedleaves();
      mv.addObject("leavedata", leavelist);
      
      return mv;
    }
    @GetMapping("rejectedleaves")
    public ModelAndView rejectedleaves()
    {
      ModelAndView mv = new ModelAndView();
      mv.setViewName("rejectedleaves");
      List<Leave> leavelist = adminService.rejectedleaves();
      mv.addObject("leavedata", leavelist);
      
      return mv;
    }
    
    @GetMapping("employeeappliedleaves")
    public ModelAndView employeeappliedleaves(HttpServletRequest request)
    {
      ModelAndView mv = new ModelAndView();
      mv.setViewName("employeeappliedleaves");
      	HttpSession session = request.getSession();
      String name=(String)session.getAttribute("ename");
      List<Leave> leavelist = employeeService.employeeappliedleaves(name);
      mv.addObject("leavedata", leavelist);

      return mv;
    }
    
    
    
	   @GetMapping("addhr")
	   public String addhr(Model m)
	   {
		   m.addAttribute("hr", new HR());
		   return "addhr";
	   }
	   
	   @PostMapping("inserthr")
	   public ModelAndView inserthr(@ModelAttribute("hr")HR h)
	   {
		   ModelAndView mv = new ModelAndView();
		   mv.setViewName("hrmsg"); 	//hrmsg is jsp file
		   
		   String msg = adminService.addhr(h);
		   mv.addObject("message", msg);
		   
		   return mv;
		   
	   }
	   
	   @GetMapping("deletehr")
	     public ModelAndView deletehr()
	     {
	       ModelAndView mv = new ModelAndView();
	       mv.setViewName("deletehr");
	       
	       List<HR> hrlist=adminService.viewallhr();
	       
	       mv.addObject("hrdata", hrlist);
	       
	       return mv;
	     }
	  
	   @GetMapping("deletehr/{id}")
	   public String deletehr(@PathVariable("id") int hid) {
	       adminService.deletehr(hid);
	       return "redirect:/deletehr";
	   }

	   
	   
	   @GetMapping("hrlogin") //URI & method name can be different
	   public ModelAndView hrlogin()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("hrlogin");
	     return mv;
	   }
	   
	   @PostMapping("checkhrlogin")
	   public ModelAndView checkhrlogin(HttpServletRequest request)
	   {
	     
	     String email = request.getParameter("email");
	     String password= request.getParameter("password");
	     HR hr=hrService.checkhrlogin(email, password);
	     
	     ModelAndView mv = new ModelAndView();
	     
	     if(hr!=null)
	     {
	       //session
	       
	       HttpSession session = request.getSession();
	       
	       session.setAttribute("hid",hr.getId()); 
	       session.setAttribute("hname",hr.getName()); 

	       mv.setViewName("hrhome");
	     }
	     else
	     {
	       mv.setViewName("hrlogin");
	       mv.addObject("message", "Login Failed");
	     }
	     
	     return mv;
	   }
	   
	   @GetMapping("hrhome")
	   public ModelAndView hrhome()
	   {
		   ModelAndView mv = new ModelAndView();
		   mv.setViewName("hrhome");
		   return mv;
	   }
    
	   @GetMapping("hrlogout")
	    public ModelAndView hrlogout()
	    {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("hrlogin");
	      mv.addObject("message", "Logout Successfully");
	      return mv;
	    }
    
	   @GetMapping("updatehrprofile")
	   public ModelAndView updatehrprofile(HttpServletRequest request)
	   {
	     ModelAndView mv = new ModelAndView();
	     
	     HttpSession session = request.getSession();
	     
	     mv.setViewName("updatehrprofile");
	     
	     mv.addObject("hid", session.getAttribute("hid"));
	     mv.addObject("hname", session.getAttribute("hname"));
	     
	     int id = (int) session.getAttribute("hid");
	    
	     HR hr=hrService.viewhrbyid(id);
	     mv.addObject("hr",hr);
	     
	     return mv;
	   }
	   
	   @PostMapping("updatehr")
	   public ModelAndView updatehr(HttpServletRequest request)
	   {
	     String msg = null;
	
	     ModelAndView mv = new ModelAndView();
	     
	       HttpSession session = request.getSession();
	     
	     mv.addObject("hid", session.getAttribute("hid"));
	     mv.addObject("hname", session.getAttribute("hname"));
	     int id = (int) session.getAttribute("hid");
	     
	    try
	    {
	      String name = request.getParameter("name");
	      String dob = request.getParameter("dob");
	      String gender=request.getParameter("gender");
	      String sal = request.getParameter("salary");
	      double salary = Double.parseDouble(sal);
	      String email = request.getParameter("email");
	      String pwd = request.getParameter("pwd");
	      String location = request.getParameter("location");
	      String contact = request.getParameter("contact");
	      
	      HR hr= new HR();
	       hr.setId(id);
	       hr.setName(name);
	       hr.setDateofbirth(dob);
	       hr.setGender(gender);
	       hr.setSalary(salary);
	       hr.setEmail(email);
	       hr.setPassword(pwd);
	       hr.setLocation(location);
	       hr.setContact(contact);
	       
	       
	       msg=hrService.updatehr(hr);
	       mv.setViewName("hrlogin");
	       mv.addObject("message",msg);
	      
	    }
	    catch(Exception e)
	    {
	      msg = e.getMessage();
	      
	      mv.setViewName("updateerror");
	       mv.addObject("message",msg);
	    }
	     
	    
	     return mv;

	   }
	   
	   @GetMapping("hrleave")
	    public ModelAndView hrleave(HttpServletRequest request)
	    {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("hrleave");
	      HttpSession session = request.getSession();
	      
	      mv.addObject("lid", session.getAttribute("hid"));
	      mv.addObject("lname", session.getAttribute("hname"));
	     
	      
	      return mv;
	    }
	    @PostMapping("inserthrleave")
	    public ModelAndView inserthrleave(HttpServletRequest request)
	    {
	      ModelAndView mv = new ModelAndView();
	        String msg = null;
	        HttpSession session = request.getSession(); 
	        try
	        {
	          
	          String name=(String)session.getAttribute("hname");
	          
	          int empid=Integer.parseInt(request.getParameter("empid"));
	          String fromd = request.getParameter("fromd");
	          String tod = request.getParameter("tod");
	          String leavetype = request.getParameter("leavetype");
	          Leave leave =new Leave();
	          
	  
	          leave.setLname(name);
	          leave.setEmpid(empid);
	          leave.setFromdate(fromd);
	          leave.setTodate(tod);
	          leave.setLeavetype(leavetype);
	          msg = hrService.applyleave(leave);
	              mv.setViewName("displayhrmsg");
	              
	  
	            mv.addObject("hname", session.getAttribute("hname"));
	              mv.addObject("message", msg);
	           
	        }
	        catch(Exception e) 
	        {
	           mv.setViewName("displayerror");
	             
	             msg = e.getMessage();
	             mv.addObject("message", msg);
	        }
	        return mv;
	    }
	    
	    @GetMapping("hrleavestatus")
	    public ModelAndView hrleavestatus(HttpServletRequest request)
	    {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("hrleavestatus");
	      	HttpSession session = request.getSession();
	      String name=(String)session.getAttribute("hname");
	      List<Leave> leavelist =hrService.hrleavestatus(name);
	      mv.addObject("leavedata", leavelist);

	      return mv;
	    }
	    
	    @GetMapping("viewempbyhr")
	    public ModelAndView viewempbyhr()
	    {
	      ModelAndView mv = new ModelAndView();
	      mv.setViewName("viewempbyhr");
	      List<Employee> emplist = adminService.viewallemps();
	      mv.addObject("empdata", emplist);
	      
	      return mv;
	    }
	    @GetMapping("deleteempbyhr")
	     public ModelAndView deleteempbyhr()
	     {
	       ModelAndView mv = new ModelAndView();
	       mv.setViewName("deleteempbyhr");
	       
	       List<Employee> emplist =  adminService.viewallemps();
	       
	       mv.addObject("empdata", emplist);
	       
	       return mv;
	     }
	    
	    @GetMapping("deleteempbyhr/{id}")
	    public String deleteactionbyhr(@PathVariable("id") int hid)
	    {
	     hrService.deleteempbyhr(hid);
	     
	      String frommail="manikantapotnuru12@gmail.com";
	      String toemail="reddy.meghanadh.mr@gmail.com";
	      String subject="Deletion Of Your Credentials";
	      String text="Your Employee Credentials has been Deleted By HR/ADMIN";
	      String mail= em.sendEmail(frommail, toemail, subject, text);
	      System.out.println(mail);
	      return "redirect:/deleteempbyhr";
	    }
	    
}