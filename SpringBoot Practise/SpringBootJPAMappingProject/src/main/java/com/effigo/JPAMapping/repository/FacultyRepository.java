package com.effigo.JPAMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.effigo.JPAMapping.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer>
{

}
