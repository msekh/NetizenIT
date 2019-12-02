package com.netizenbd.springbootApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.netizenbd.springbootApp.entity.ClassRoom;

@Service
public interface ClassRoomService {
	List<ClassRoom> getAllClassRoom();

	ClassRoom createClassRoom(ClassRoom room);

	Optional<ClassRoom> getClassRoomByCode(String code);

	ClassRoom updateClassRoom(ClassRoom room);

	void deleteClassRoom(String code);

	List<ClassRoom> findClassRoomsByTitleContainsIgnoreCase(String title);

	List<ClassRoom> findClassroomsByDescriptionContainsIgnoreCase(String description);

	List<ClassRoom> findClassroomsByTitleAndAndDescription(@Param("title") String title,
			@Param("description") String description);

}
