package com.effigo.elms.repository;
 
 import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import
 org.springframework.stereotype.Repository;

import com.effigo.elms.model.HR;
import com.effigo.elms.model.Leave;
 
 
 @Repository 
 public interface HRRepository extends JpaRepository<HR, Integer>{
 
 @Query("select hr from HR hr where hr.email=?1 and hr.password=?2 ") 
 public HR checkhrlogin(String email , String password);
 
 @Query("SELECT l FROM Leave l WHERE  l.lname = ?1")
	public List<Leave> hrleavestatus(String name);
 }