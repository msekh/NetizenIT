package com.netizenbd.springbootApp.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netizenbd.springbootApp.entity.ClassRoutine;
@Repository
public interface ClassRoutineRepository extends JpaRepository<ClassRoutine, Integer> {

}
