package com.netizenbd.springbootApp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netizenbd.springbootApp.entity.Student;
import com.netizenbd.springbootApp.entity.TutorReportsDTO;
import com.netizenbd.springbootApp.exeption.ResourceNotFoundException;
import com.netizenbd.springbootApp.repository.StudentRepository;

@Service
public class StudentServiceImpl {

	@Autowired
	private StudentRepository repo;

	public Map<Long, Student> getAllStudentsUsingMap() {
		Map<Long, Student> studentMap = new HashMap<>();

		for (Student student : getAllStudents()) {
			studentMap.put(student.getId(), student);
		}
		return studentMap;

		/*
		 * for (Map.Entry<Integer, Student> map : studentMap.entrySet()) {
		 * System.out.println(map.getKey() + " "+map.getValue()); }
		 */

	}

	public Student createStudent(Student student) {
		return repo.save(student);
	}

	
	
	public Student updateStudent(Student student) {
		return this.repo.save(student);
	}

	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	public Optional<Student> getStudentById(Long id) {
		return Optional.ofNullable(getAllStudentsUsingMap().get(id));

	}

	public void deleteStudent(Long id) {
		Student deleteStudent = this.repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
		this.repo.delete(deleteStudent);
	}
		
	public List<Student> getAllStudentsByTeacherId(Long tId){
		return this.repo.findByTeacher_Id(tId);
	}
	
	public TutorReportsDTO getSingleTutorReports() {

		//Student student = repo.;
		//TutorReportsDTO tr = new TutorReportsDTO();
		
		return new TutorReportsDTO();
	}

}
