package com.netizenbd.springbootApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netizenbd.springbootApp.dao.StudentRepository;
import com.netizenbd.springbootApp.entity.Student;
import com.netizenbd.springbootApp.exeption.ResourceNotFoundException;

@Service
public class StudentServiceImpl {

	@Autowired
	private StudentRepository repo;

	
	public Student createStudent(Student student) {
		return repo.save(student);
	}

	
	public Student updateStudent(Student student) {
		return this.repo.save(student);
	}

	
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	
	public Optional<Student> getStudentById(long i) {
		return Optional.ofNullable(this.repo.findById(i)).orElseThrow(() -> new ResourceNotFoundException("Student", "id", i));
	}

	public void deleteStudent(Long id) {
		Student deleteStudent = this.repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
		this.repo.delete(deleteStudent);
	}

}
