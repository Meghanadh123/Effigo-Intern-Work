package com.effigo.elms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.effigo.elms.model.Admin;
import com.effigo.elms.model.Leave;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> 
{
	@Query(" select a from Admin a where a.username=?1 and a.password=?2 ")
	public Admin checkadminlogin(String uname,String pwd);
	@Modifying
	@Transactional //commit changes
    @Query("update Employee e  set e.active=?2 where e.id=?1")
    public int updatestatus(int eid,boolean status);
	
	@Modifying
	@Transactional //commit changes
    @Query("update Leave l set l.status=?2 where l.sno=?1")
    public int updateleavestatus(int sno,boolean status);
	
	@Query("SELECT l FROM Leave l WHERE l.status = true")
	public List<Leave> approvedleaves();
	
	@Query("SELECT l FROM Leave l WHERE l.status = false")
	public List<Leave> rejectedleaves();
	
}