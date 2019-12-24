package com.netizenbd.springbootApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netizenbd.springbootApp.dto.StudentDTO;
import com.netizenbd.springbootApp.dto.TeacherDTO;
import com.netizenbd.springbootApp.dto.TutorReportsDTO;
import com.netizenbd.springbootApp.entity.Student;
import com.netizenbd.springbootApp.entity.Teacher;
import com.netizenbd.springbootApp.entity.TeacherType;
import com.netizenbd.springbootApp.repository.StudentRepository;
import com.netizenbd.springbootApp.repository.TeacherRepository;

import lombok.NonNull;

@Service
public class TeacherServeiceImpl {
	@Autowired
	private TeacherRepository repo;
	@Autowired
	private StudentRepository sRepo;

	public Optional<StudentDTO> copyStudentFromEntity(Optional<Student> student) {
		if (student.isPresent() && student.get().getId() != null) {
			StudentDTO studentDTO = new StudentDTO();
			BeanUtils.copyProperties(student.get(), studentDTO);
			return Optional.ofNullable(studentDTO);
		}
		return Optional.empty();
	}

	public Optional<TeacherDTO> copyTeacherFromEntity(Optional<Teacher> teacher) {
		if (teacher.isPresent() && teacher.get().getId() != null) {
			TeacherDTO teacherDTO = new TeacherDTO();
			BeanUtils.copyProperties(teacher.get(), teacherDTO);
			return Optional.ofNullable(teacherDTO);
		}
		return Optional.empty();
	}

	public List<Teacher> getAllTeachers() {
		return this.repo.findAll();
	}

	public Teacher addTeacher(Teacher teacher) {
		return this.repo.save(teacher);
	}

	public Teacher upateTeacher(Teacher teacher) {
		return this.repo.saveAndFlush(teacher);
	}

	public List<Teacher> getAllTeachersByType(TeacherType type) {
		return repo.findByType(type);
	}

	public TutorReportsDTO findTutorReportsDTOById(Long id) {
		return repo.findById(id).map(t -> {

			List<StudentDTO> sDtos = studentDTOList(id);

			return new TutorReportsDTO(t.getId(), t.getTeacherName(), sDtos);
		}).orElseGet(null);
	}

	public List<StudentDTO> studentDTOList(Long id) {

		return sRepo.findByTeacher_Id(id).stream()
				//.filter(th -> th.getTeacher().getId() == id)
				//.peek(System.out::println)
				.map(s -> getStudentDTOFromStudent(s))
				.collect(Collectors.toList());
	}

	private TeacherDTO getTeacherDTOFromTeacher(Teacher teacher) {

		TeacherDTO teacherDTO = new TeacherDTO();
		teacherDTO.setId(teacher.getId());
		teacherDTO.setTeacherName(teacher.getTeacherName());
		teacherDTO.setType(teacher.getType());
		return teacherDTO;
	}

	// TODO
	private StudentDTO getStudentDTOFromStudent(Student student) {

		StudentDTO studentDTOs = new StudentDTO();
		studentDTOs.setId(student.getId());
		studentDTOs.setFirstName(student.getFirstName());
		studentDTOs.setLastName(student.getLastName());
		studentDTOs.setRollId(student.getRollId());
		studentDTOs.setTeacherDTO(getTeacherDTOFromTeacher(student.getTeacher()));
		return studentDTOs;
	}

	public TutorReportsDTO findSingleTeacherAllStudents(Long teacherId) {

		//List<Student> singleTeacherAllStudents = sRepo.findByTeacher_Id(teacherId);
		List<StudentDTO> singleTeacherAllStudents  = studentDTOList(teacherId);
		if (singleTeacherAllStudents.isEmpty()) {
			return null;
		}

		TeacherDTO teacher = singleTeacherAllStudents.stream().map(student -> student.getTeacherDTO()).findFirst().get();

		return copyStudentToTutorReportsDTO(singleTeacherAllStudents, teacher);
	}

	public TutorReportsDTO copyStudentToTutorReportsDTO(List<StudentDTO> students, TeacherDTO teacher) {

		List<StudentDTO> studentDTOs = new ArrayList<>();
		TutorReportsDTO tutorReportsDTO = new TutorReportsDTO();
		tutorReportsDTO.setTeacherId(teacher.getId());
		tutorReportsDTO.setTeacherName(teacher.getTeacherName());

		students.forEach(student -> {
			
			studentDTOs.add(student);
		});

		tutorReportsDTO.setStudents(studentDTOs);

		return tutorReportsDTO;

	}

	/*
	 * public List<TutorReportsDTO> findAllTutorReportsDTOs() {
	 * 
	 * 
	 * List<TutorReportsDTO> tDtos = new ArrayList<TutorReportsDTO>(); for (Teacher
	 * t : repo.findAll()) { TutorReportsDTO tDto = new TutorReportsDTO(t.getId(),
	 * t.getTeacherName(), sRepo.findByTeacher_Id(t.getId())); tDtos.add(tDto); }
	 * return tDtos;
	 * 
	 * 
	 * return repo.findAll().stream().map(t -> {
	 * 
	 * TutorReportsDTO tDto = new TutorReportsDTO(t.getId(), t.getTeacherName(),
	 * sRepo.findByTeacher_Id(t.getId()));
	 * 
	 * return new TutorReportsDTO(t.getId(), t.getTeacherName(),
	 * sRepo.findByTeacher_Id(t.getId())); }).collect(Collectors.toList());
	 * 
	 * }
	 */
}
