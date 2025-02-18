package com.effigo.MVCJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.effigo.MVCJPA.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
	@Query(" select a from Admin a where a.username=?1 and a.password=?2 ")
	public Admin checkadminlogin(String uname,String pwd);
	
	@Modifying
	@Transactional //commit changes
    @Query("update Employee e  set e.active=?2 where e.id=?1")
    public int updatestatus(int eid,boolean status);
	
	
}
