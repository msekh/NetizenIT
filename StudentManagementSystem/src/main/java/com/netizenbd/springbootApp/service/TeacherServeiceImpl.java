package com.netizenbd.springbootApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netizenbd.springbootApp.dao.TeacherRepository;
import com.netizenbd.springbootApp.entity.Teacher;
import com.netizenbd.springbootApp.entity.TeacherType;

@Service
public class TeacherServeiceImpl {
	@Autowired
	private TeacherRepository repo;

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

}
