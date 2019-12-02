package com.netizenbd.springbootApp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netizenbd.springbootApp.dao.StudentRepository;
import com.netizenbd.springbootApp.entity.Student;
import com.netizenbd.springbootApp.exeption.ResourceNotFoundException;
import com.netizenbd.springbootApp.service.StudentService;

@RestController
@RequestMapping("/crud/api")
public class StudentController {
	@Autowired
	StudentRepository repo;
	@Autowired
	private StudentService studentService;

	/* Show all Students */
	@GetMapping("/all_students")
	public ResponseEntity<List<Student>> getAllProduct() {
		return ResponseEntity.ok().body(studentService.getAllStudents());
	}

	/* Add a Student */
	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(@RequestBody Student Student) {
		return ResponseEntity.ok().body(this.studentService.createStudent(Student));
	}

	/* Find a student */
	@GetMapping("/students/{id}")
	public Optional<Student> getStudentById(@PathVariable(value = "id") Long id) {
		return Optional.ofNullable(this.studentService.getStudentById(id)).orElseThrow(() -> new ResourceNotFoundException("Student ", "id", id));
		
	}

	
	/* update a student */
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long sId,
			@Valid @RequestBody Student studentDetails) {
		Student student = this.repo.findById(sId)
				.orElseThrow(() -> new ResourceNotFoundException("Student", "id", sId));
		student.setFirstName(studentDetails.getFirstName());
		student.setLastName(studentDetails.getLastName());

		final Student updateStudent = studentService.updateStudent(student);
		return ResponseEntity.ok(updateStudent);
	}

	/* Delete A Student */
	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable(value = "id") Long sId) {
		studentService.deleteStudent(sId);
		return "Deleted";
	}
}
