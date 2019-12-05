package com.netizenbd.springbootApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.netizenbd.springbootApp.entity.ClassDetails;
import com.netizenbd.springbootApp.entity.ClassRoom;
import com.netizenbd.springbootApp.entity.Course;
import com.netizenbd.springbootApp.entity.Student;
import com.netizenbd.springbootApp.entity.Teacher;
import com.netizenbd.springbootApp.entity.TeacherType;
import com.netizenbd.springbootApp.service.ClassDetailsServiceImpl;
import com.netizenbd.springbootApp.service.ClassRoomServiceImpl;
import com.netizenbd.springbootApp.service.CourseServiceImpl;
import com.netizenbd.springbootApp.service.StudentServiceImpl;
import com.netizenbd.springbootApp.service.TeacherServeiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBootCrudApplication implements CommandLineRunner {
	@Autowired
	private StudentServiceImpl service;
	@Autowired
	private ClassRoomServiceImpl classService;
	@Autowired
	private ClassDetailsServiceImpl classDetailsService;
	@Autowired
	private TeacherServeiceImpl teacherServeice;
	@Autowired
	private CourseServiceImpl courseService;
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/* Sudent */
		service.createStudent(new Student("Sekh", "Mahadi"));
		service.createStudent(new Student("Shekh", "Rupon"));
		service.createStudent(new Student("Shekh", "Niaz"));

		log.info("All Studentss -> {}", service.getAllStudents());
		log.info("Single Student -> {}", service.getStudentById(2));
		/* Class Room */
		classService.addClassRoom(new ClassRoom("C04", 20, "Available"));
		classService.addClassRoom(new ClassRoom("C10", 30, "unAvailable"));
		classService.addClassRoom(new ClassRoom("C09", 25, "Available"));
		classService.addClassRoom(new ClassRoom("C20", 40, "Available"));
		classService.addClassRoom(new ClassRoom("C08", 35, "Available"));

		log.info("All Class Room -> {}", classService.getAllClassRoom());
		log.info("All Class Room Find By title and description-> {}",
				classService.findClassroomsByDescriptionIgnoreCase("Available"));
		
		/* Class Details */
		classDetailsService.addClassDetails(new ClassDetails("One", 30));
		classDetailsService.addClassDetails(new ClassDetails("Two", 20));
		classDetailsService.addClassDetails(new ClassDetails("Three", 34));
		classDetailsService.addClassDetails(new ClassDetails("Four", 25));
		classDetailsService.addClassDetails(new ClassDetails("Five", 40));
		classDetailsService.addClassDetails(new ClassDetails("Six", 30));
		classDetailsService.addClassDetails(new ClassDetails("seven", 35));
		log.info("All Class Details -> {}", classDetailsService.getAllClassDetails());
		
		
		/* Teacher */
		teacherServeice.addTeacher(new Teacher("Abdul salam", TeacherType.REGULAR));
		teacherServeice.addTeacher(new Teacher("Bashar", TeacherType.PARTTIME));
		log.info("All Teachers -> {}", teacherServeice.getAllTeachers());
		log.info("All Teachers by type -> {}",teacherServeice.getAllTeachersByType(TeacherType.PARTTIME));
		
		/*Course*/
		courseService.addCourse(new Course("Physics", "PHY"));
		courseService.addCourse(new Course("Chemistry", "CHE"));
		courseService.addCourse(new Course("Bangla", "BAN"));
		courseService.addCourse(new Course("English", "ENG"));
		courseService.addCourse(new Course("Math", "MAT"));
		
		log.info("All Courses -> {}", courseService.getAllCourse());
		
		
	}

}
