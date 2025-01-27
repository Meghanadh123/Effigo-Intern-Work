package com.effigo.JPAMapping.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.effigo.JPAMapping.model.Course;
import com.effigo.JPAMapping.model.Faculty;
import com.effigo.JPAMapping.model.FacultyCourseMapping;

public interface FacultyCourseMappingRepository extends CrudRepository<FacultyCourseMapping, Integer>
{
  @Query("SELECT COUNT(fcm) FROM FacultyCourseMapping fcm where fcm.faculty = ?1 and fcm.course = ?2 AND fcm.section = ?3")
  public long checkfcoursemapping(Faculty faculty,Course course,int section);
}
