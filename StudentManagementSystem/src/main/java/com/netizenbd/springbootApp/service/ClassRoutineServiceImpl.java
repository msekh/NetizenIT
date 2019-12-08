package com.netizenbd.springbootApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netizenbd.springbootApp.dao.ClassRoutineRepository;
import com.netizenbd.springbootApp.entity.ClassRoutine;

@Service
public class ClassRoutineServiceImpl {
	@Autowired
	private ClassRoutineRepository repo;
	
	
	
	public ClassRoutine addRoutine(ClassRoutine routine) {
		return this.repo.save(routine);
	}
	
	public List<ClassRoutine> getAllRoutines(){
		return repo.findAll();
	}
}
