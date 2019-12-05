package com.netizenbd.springbootApp.service;

import java.util.List;
import java.util.Optional;

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

	public ClassRoom addClassRoom(ClassRoom room) {

		return this.repo.save(room);
	}

	public Optional<ClassRoom> getClassRoomById(Integer roomId) {

		return Optional.ofNullable(this.repo.findById(roomId)).orElseThrow(() -> new ResourceNotFoundException("Room", "id", roomId));
	}

	public ClassRoom updateClassRoom(ClassRoom room) {

		return this.repo.saveAndFlush(room);
	}

	public void deleteClassRoom(Integer roomId) {
		ClassRoom deleteRoom = this.repo.findById(roomId)
				.orElseThrow(() -> new ResourceNotFoundException("Class Room", "id", roomId));
		this.repo.delete(deleteRoom);
	}

	public List<ClassRoom> findClassRoomsByRoomNoIgnoreCase(String room_no) {
		// List<ClassRoom> room = repo.findAll(); // or this.getAllClassRoom();

		/*
		 * return this.repo.findAll().stream() .filter(titleList -> titleList.getTitle()
		 * != null && title.equalsIgnoreCase(titleList.getTitle()))
		 * .collect(Collectors.toList());
		 */
		return this.repo.findByRoomNo(room_no);
	}

	public List<ClassRoom> findClassroomsByDescriptionIgnoreCase(String description) {
		// List<ClassRoom> room = repo.findAll(); // or this.getAllClassRoom();

		/*
		 * return repo.findAll().stream().filter(descriptionList ->
		 * descriptionList.getDescription() != null &&
		 * description.equalsIgnoreCase(descriptionList.getTitle())).collect(Collectors.
		 * toList());
		 */
		return this.repo.findByDescription(description);
		}

	public List<ClassRoom> findClassRoomByRoomNoAndAndDescription(String room_no, String description) {
		 return this.repo.findByRoomNoAndDescription(room_no, description);
	}

}
