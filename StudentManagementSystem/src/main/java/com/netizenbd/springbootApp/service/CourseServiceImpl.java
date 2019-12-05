package com.netizenbd.springbootApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netizenbd.springbootApp.dao.CourseRepository;
import com.netizenbd.springbootApp.entity.Course;
import com.netizenbd.springbootApp.exeption.ResourceNotFoundException;

@Service
public class CourseServiceImpl {
	@Autowired
	private CourseRepository repo;

	public List<Course> getAllCourse(){
		return repo.findAll();
	}
	
	public Course getByCourseId(Integer cId) {
		return repo.findById(cId).orElseThrow(() -> new ResourceNotFoundException("Course", "id", cId));
	}
	
	public Course addCourse(Course course) {
		return repo.save(course);
	}
}
