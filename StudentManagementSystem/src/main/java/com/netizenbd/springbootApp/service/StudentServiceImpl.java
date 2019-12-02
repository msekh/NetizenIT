package com.netizenbd.springbootApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netizenbd.springbootApp.dao.StudentRepository;
import com.netizenbd.springbootApp.entity.Student;
import com.netizenbd.springbootApp.exeption.ResourceNotFoundException;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;

	@Override
	public Student createStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return this.repo.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	@Override
	public Optional<Student> getStudentById(long studentId) {
		return Optional.ofNullable(this.repo.findById(studentId)).orElseThrow(() -> new ResourceNotFoundException("Student", "id", studentId));
	}

	@Override
	public void deleteStudent(Long id) {
		Student deleteStudent = this.repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
		this.repo.delete(deleteStudent);
	}

}
