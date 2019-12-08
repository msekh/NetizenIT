package com.netizenbd.springbootApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netizenbd.springbootApp.dao.ClassRoutineRepository;
import com.netizenbd.springbootApp.entity.ClassRoutine;
import com.netizenbd.springbootApp.service.ClassRoutineServiceImpl;

@RestController
@RequestMapping("/class_routine")
public class ClassRoutineController {
	@Autowired
	private ClassRoutineRepository repo;
	@Autowired
	private ClassRoutineServiceImpl service;

	@GetMapping("/all_class_routine_list")
	public ResponseEntity<List<ClassRoutine>> getAllClassRoutine() {
		return ResponseEntity.ok().body(this.service.getAllRoutines());
	}
}
