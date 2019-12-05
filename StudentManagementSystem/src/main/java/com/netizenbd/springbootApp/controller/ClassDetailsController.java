package com.netizenbd.springbootApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netizenbd.springbootApp.entity.ClassDetails;
import com.netizenbd.springbootApp.service.ClassDetailsServiceImpl;

@RestController
@RequestMapping("/classDetails/api")
public class ClassDetailsController {
	@Autowired
	private ClassDetailsServiceImpl service;
	
	@GetMapping("/all_class_details")
	ResponseEntity<List<ClassDetails>> getAllClassDetails(){
		return ResponseEntity.ok().body(service.getAllClassDetails());
	}

}
