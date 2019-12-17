package com.netizenbd.springbootApp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netizenbd.springbootApp.dto.TutorReportsDTO;
import com.netizenbd.springbootApp.entity.Teacher;
import com.netizenbd.springbootApp.entity.TeacherType;
import com.netizenbd.springbootApp.exeption.ResourceNotFoundException;
import com.netizenbd.springbootApp.repository.StudentRepository;
import com.netizenbd.springbootApp.repository.TeacherRepository;
import com.netizenbd.springbootApp.service.TeacherServeiceImpl;

@RestController
@RequestMapping("/teacher/api")
public class TeacherController {

	@Autowired
	private TeacherRepository repo;
	@Autowired
	private TeacherServeiceImpl teacherServeice;
	@Autowired
	private StudentRepository sRepo;

	@GetMapping("/all_teachers")
	public ResponseEntity<List<Teacher>> getAllTeaches() {
		return ResponseEntity.ok().body(teacherServeice.getAllTeachers());
	}

	@GetMapping("/get_teacher_by_type/{type}")
	public ResponseEntity<List<Teacher>> getTeachersByType(@PathVariable(value = "type") TeacherType type) {
		return ResponseEntity.ok().body(teacherServeice.getAllTeachersByType(type));
	}

	@PostMapping("/add_teacher")
	public ResponseEntity<Teacher> addTeacher(@Valid @RequestBody Teacher teacher) {
		return ResponseEntity.ok().body(this.teacherServeice.addTeacher(teacher));
	}

	@PutMapping("/update_teacher/{tId}")
	public ResponseEntity<Teacher> updateTeacher(@PathVariable(value = "tId") Long tId,
			@Valid @RequestBody Teacher teacherDetails) {
		Teacher teacher = this.repo.findById(tId)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher not found.", "id", tId));

		teacher.setTeacherName(teacherDetails.getTeacherName());
		teacher.setType(teacherDetails.getType());

		final Teacher upateTeacher = teacherServeice.upateTeacher(teacher);

		return ResponseEntity.ok(upateTeacher);
	}

	@GetMapping("/single_tutor/{id}")
	public ResponseEntity<TutorReportsDTO> getSingleTutor(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok().body(teacherServeice.findSingleTeacherAllStudents(id));
	}

	/*
	 * @GetMapping("/all_tutors") public ResponseEntity<List<TutorReportsDTO>>
	 * getAllTutorReports(){ return
	 * ResponseEntity.ok().body(teacherServeice.findAllTutorReportsDTOs()); }
	 */
}
