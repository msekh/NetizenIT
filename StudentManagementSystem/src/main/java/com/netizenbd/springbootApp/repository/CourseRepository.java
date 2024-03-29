package com.netizenbd.springbootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netizenbd.springbootApp.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	 List<Course> findByCourseName(String couseName);
	
}
