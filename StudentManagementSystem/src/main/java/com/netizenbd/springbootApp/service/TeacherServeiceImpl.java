package com.netizenbd.springbootApp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netizenbd.springbootApp.dto.TutorReportsDTO;
import com.netizenbd.springbootApp.entity.Teacher;
import com.netizenbd.springbootApp.entity.TeacherType;
import com.netizenbd.springbootApp.repository.StudentRepository;
import com.netizenbd.springbootApp.repository.TeacherRepository;

@Service
public class TeacherServeiceImpl {
	@Autowired
	private TeacherRepository repo;
	@Autowired
	private StudentRepository sRepo;

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
			// TutorReportsDTO tDto = new TutorReportsDTO(t.getId(), t.getTeacherName(),
			// sRepo.findByTeacher_Id(id));
			/*
			 * return new TutorReportsDTO(t.getId(), t.getTeacherName(), //
			 * sRepo.findByTeacher_Id(id));
			 */
			return new TutorReportsDTO(t.getId(), t.getTeacherName(), sRepo.findByTeacherDTO_Id(id));
		}).orElseGet(null);
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
