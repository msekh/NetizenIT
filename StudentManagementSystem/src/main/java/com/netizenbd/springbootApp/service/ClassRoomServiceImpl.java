package com.netizenbd.springbootApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netizenbd.springbootApp.dao.ClassRoomRepository;
import com.netizenbd.springbootApp.entity.ClassRoom;
import com.netizenbd.springbootApp.exeption.ResourceNotFoundException;

@Service
public class ClassRoomServiceImpl implements ClassRoomService {

	@Autowired
	private ClassRoomRepository repo;

	@Override
	public List<ClassRoom> getAllClassRoom() {
		return repo.findAll();
	}

	@Override
	public ClassRoom createClassRoom(ClassRoom room) {

		return this.repo.save(room);
	}

	@Override
	public Optional<ClassRoom> getClassRoomByCode(String code) {

		return this.repo.findById(code);
	}

	@Override
	public ClassRoom updateClassRoom(ClassRoom room) {

		return this.repo.saveAndFlush(room);
	}

	@Override
	public void deleteClassRoom(String code) {
		ClassRoom deleteRoom = this.repo.findById(code)
				.orElseThrow(() -> new ResourceNotFoundException("Class Room", "id", code));
		this.repo.delete(deleteRoom);
	}

	@Override
	public List<ClassRoom> findClassRoomsByTitleContainsIgnoreCase(String title) {
		
		return null;
	}

	@Override
	public List<ClassRoom> findClassroomsByDescriptionContainsIgnoreCase(String description) {
		
		return null;
	}

	@Override
	public List<ClassRoom> findClassroomsByTitleAndAndDescription(String title, String description) {
		
		return null;
	}

}
