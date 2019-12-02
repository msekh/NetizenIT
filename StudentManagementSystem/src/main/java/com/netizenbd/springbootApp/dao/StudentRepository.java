package com.netizenbd.springbootApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netizenbd.springbootApp.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
