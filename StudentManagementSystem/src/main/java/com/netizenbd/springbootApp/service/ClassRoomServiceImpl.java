package com.netizenbd.springbootApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netizenbd.springbootApp.dao.ClassRoomRepository;
import com.netizenbd.springbootApp.entity.ClassRoom;
import com.netizenbd.springbootApp.exeption.ResourceNotFoundException;

@Service
public class ClassRoomServiceImpl {

	@Autowired
	private ClassRoomRepository repo;

	public List<ClassRoom> getAllClassRoom() {
		return repo.findAll();
	}

	public ClassRoom createClassRoom(ClassRoom room) {

		return this.repo.save(room);
	}

	public Optional<ClassRoom> getClassRoomByCode(String code) {

		return this.repo.findById(code);
	}

	public ClassRoom updateClassRoom(ClassRoom room) {

		return this.repo.saveAndFlush(room);
	}

	public void deleteClassRoom(String code) {
		ClassRoom deleteRoom = this.repo.findById(code)
				.orElseThrow(() -> new ResourceNotFoundException("Class Room", "id", code));
		this.repo.delete(deleteRoom);
	}

	public List<ClassRoom> findClassRoomsByTitleContainsIgnoreCase(String title) {
		//List<ClassRoom> room = repo.findAll(); // or this.getAllClassRoom();

		return this.repo.findAll().stream()
				.filter(titleList -> titleList.getTitle() != null && title.equalsIgnoreCase(titleList.getTitle()))
				.collect(Collectors.toList());
	}

	public List<ClassRoom> findClassroomsByDescriptionContainsIgnoreCase(String description) {
		//List<ClassRoom> room = repo.findAll(); // or this.getAllClassRoom();

		return repo.findAll().stream().filter(descriptionList -> descriptionList.getDescription() != null
				&& description.equalsIgnoreCase(descriptionList.getTitle())).collect(Collectors.toList());
	}

	public List<ClassRoom> findClassroomsByTitleAndAndDescription(String title, String description) {
		 List<ClassRoom> classrooms = new ArrayList<>();
	        if (title != null && description != null) {
	            classrooms = findClassroomsByTitleAndAndDescription(title, description);
	        } else if (title != null) {
	            classrooms = findClassRoomsByTitleContainsIgnoreCase(title);
	        } else if (description != null) {
	            classrooms = findClassroomsByDescriptionContainsIgnoreCase(description);
	        } else {
	            classrooms = repo.findAll();
	        }
	        return classrooms;
	}

}
