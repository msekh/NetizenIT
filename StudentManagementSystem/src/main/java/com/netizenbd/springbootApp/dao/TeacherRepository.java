package com.netizenbd.springbootApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netizenbd.springbootApp.entity.Teacher;
import com.netizenbd.springbootApp.entity.TeacherType;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	
	Optional<Teacher> findById(Long tId);

	List<Teacher> findByTeacherName(String teacherName);

	List<Teacher> findByType(TeacherType type);
	
}
