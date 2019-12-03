package com.netizenbd.springbootApp.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netizenbd.springbootApp.entity.ClassRoom;

@Repository
public interface ClassRoomRepository extends JpaRepository<ClassRoom, String> {

}
