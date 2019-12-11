package com.netizenbd.springbootApp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.netizenbd.springbootApp.dto.StudentDTO;
import com.netizenbd.springbootApp.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
List<Student> findByTeacher_Id(Long teacherId);

@Transactional
List<StudentDTO> findByTeacherDTO_Id(Long teacherId);
}
