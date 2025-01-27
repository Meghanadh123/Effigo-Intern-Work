package com.effigo.JPAMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.effigo.JPAMapping.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>
{
}
