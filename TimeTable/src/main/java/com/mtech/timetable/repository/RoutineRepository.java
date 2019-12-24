package com.mtech.timetable.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtech.timetable.entity.Routine;

public interface RoutineRepository extends JpaRepository<Routine, Long>{

}
