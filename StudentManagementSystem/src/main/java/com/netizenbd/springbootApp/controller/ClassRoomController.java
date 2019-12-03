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

import com.netizenbd.springbootApp.dao.ClassRoomRepository;
import com.netizenbd.springbootApp.entity.ClassRoom;
import com.netizenbd.springbootApp.exeption.ResourceNotFoundException;
import com.netizenbd.springbootApp.service.ClassRoomServiceImpl;

@RestController
@RequestMapping("/classes/api")
public class ClassRoomController {

	@Autowired
	private ClassRoomServiceImpl service;
	@Autowired
	private ClassRoomRepository repo;

	@GetMapping("/all_classes")
	public ResponseEntity<List<ClassRoom>> getAllRoom() {
		return ResponseEntity.ok().body(service.getAllClassRoom());
	}

	@PostMapping("/add_classroom")
	public ResponseEntity<ClassRoom> createClassroom(@RequestBody ClassRoom room) {
		return ResponseEntity.ok().body(this.service.createClassRoom(room));
	}

	@GetMapping("/class/{code}")
	public Optional<ClassRoom> getRoomByCode(@PathVariable(value = "code") String code) {
		return Optional.ofNullable(this.repo.findById(code)
				.orElseThrow(() -> new ResourceNotFoundException("Class Room code", "code", code)));
	}

	/* update a class room */
	@PutMapping("/class/{code}")
	public ResponseEntity<ClassRoom> updateRoom(@PathVariable(value = "code") String code,
			@Valid @RequestBody ClassRoom roomDetails) {

		ClassRoom room = this.repo.findById(code)
				.orElseThrow(() -> new ResourceNotFoundException("Room", "code", code));
		
		room.setTitle(roomDetails.getTitle());
		room.setDescription(roomDetails.getDescription());
		
		final ClassRoom updateRoom = service.updateClassRoom(room);
		return ResponseEntity.ok(updateRoom);

	}
	@GetMapping("/class/{title}")
	public ResponseEntity<List<ClassRoom>>findClassRoomsByTitleIgnoreCase(@PathVariable(value = "title")String title){
		return ResponseEntity.ok().body(service.findClassroomsByDescriptionContainsIgnoreCase(title));	
	}
	
	
}
