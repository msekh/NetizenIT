package com.netizenbd.springbootApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netizenbd.springbootApp.entity.ClassRoom;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Integer> {

	List<ClassRoom> findByRoomNo(String roomNo);;

	List<ClassRoom> findByCapasity(Integer capasity);

	List<ClassRoom> findByDescription(String description);

	List<ClassRoom> findByRoomNoAndDescription(String room_no, String description);
}
