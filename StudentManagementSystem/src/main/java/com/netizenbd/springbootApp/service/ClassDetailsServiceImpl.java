package com.netizenbd.springbootApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netizenbd.springbootApp.entity.ClassDetails;
import com.netizenbd.springbootApp.exeption.ResourceNotFoundException;
import com.netizenbd.springbootApp.repository.ClassDetailsRepository;
@Service
public class ClassDetailsServiceImpl {
	@Autowired
	private ClassDetailsRepository repo;

	public List<ClassDetails> getAllClassDetails() {
		return this.repo.findAll();
	}

	public Optional<ClassDetails> findClassDetailsById(Integer classId) {
		return Optional.ofNullable(this.repo.findById(classId))
				.orElseThrow(() -> new ResourceNotFoundException("Class Details", "id", classId));
	}

	public ClassDetails addClassDetails(ClassDetails classDetails) {
		return this.repo.save(classDetails);
	}
	
}
