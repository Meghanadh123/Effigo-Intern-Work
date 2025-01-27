package com.effigo.elms.service;

import java.util.List;

import com.effigo.elms.model.HR;
import com.effigo.elms.model.Leave;

public interface HRService
{
//	public String addhr (HR hr);
    public String updatehr(HR hr);
   public HR viewhrbyid(int eid);
	public String deleteempbyhr(int eid);
	public HR checkhrlogin(String email, String password);
	public String applyleave(Leave leave);
	public List<Leave> hrleavestatus(String name);
//	List<Leave> hrappliedleaves(String name);

}
