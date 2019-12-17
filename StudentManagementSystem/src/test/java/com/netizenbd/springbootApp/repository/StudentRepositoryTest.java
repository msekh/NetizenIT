package com.netizenbd.springbootApp.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.netizenbd.springbootApp.entity.Student;
import com.netizenbd.springbootApp.entity.Teacher;
import com.netizenbd.springbootApp.entity.TeacherType;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentRepositoryTest {
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private TeacherRepository teacherRepository;

	/*
	 * @Test void testGetAllStudents() {
	 * studentRepo.findAll().stream().peek(System.out::println);
	 * 
	 * // assertThat(students).hasSize(4); }
	 */

	@Test
	void testSaveTeacher() {
		for (Teacher teacher : teacherList()) {
			this.teacherRepository.save(teacher);
		}
	}

	@Test
	void testSaveStudent() {
		for (Student student : studentsList()) {
			this.studentRepo.save(student);
		}
	}

	private List<Teacher> teacherList() {
		return Arrays.asList(new Teacher("Abdul salam", TeacherType.REGULAR),
				new Teacher("Bashar", TeacherType.PARTTIME), new Teacher("Abdul kadir", TeacherType.CONTRUCTUAL));

	}

	private List<Student> studentsList() {
		return Arrays.asList(new Student("Sekh", "Mahadi", 101l, teacherList().get(0)),
				new Student("Shekh", "Rupon", 102l, teacherList().get(1)),
				new Student("Shekh", "Niaz", 104l, teacherList().get(0)),
				new Student("Abid", "hasan", 103l, teacherList().get(2)));
	}
}
