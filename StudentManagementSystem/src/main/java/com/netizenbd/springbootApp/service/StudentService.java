package com.netizenbd.springbootApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.netizenbd.springbootApp.entity.Student;

@Service
public interface StudentService {
	Student createStudent(Student student);

	Student updateStudent(Student student);

	List<Student> getAllStudents();

	Optional<Student> getStudentById(long studentId);

	void deleteStudent(Long id);

}