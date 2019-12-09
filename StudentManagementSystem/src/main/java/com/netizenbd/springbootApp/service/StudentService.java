package com.netizenbd.springbootApp.service;

import java.util.List;
import java.util.Optional;

import com.netizenbd.springbootApp.entity.Student;


public interface StudentService {
	
	Student createStudent(Student student);

	Student updateStudent(Student student);

	List<Student> getAllStudents();

	Optional<Student> getStudentById(long studentId);

	void deleteStudent(Long id);

}
