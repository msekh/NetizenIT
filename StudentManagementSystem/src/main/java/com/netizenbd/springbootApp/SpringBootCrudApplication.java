package com.netizenbd.springbootApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.netizenbd.springbootApp.entity.ClassDetails;
import com.netizenbd.springbootApp.entity.ClassRoom;
import com.netizenbd.springbootApp.entity.ClassRoutine;
import com.netizenbd.springbootApp.entity.Course;
import com.netizenbd.springbootApp.entity.Student;
import com.netizenbd.springbootApp.entity.Teacher;
import com.netizenbd.springbootApp.entity.TeacherType;
import com.netizenbd.springbootApp.service.ClassDetailsServiceImpl;
import com.netizenbd.springbootApp.service.ClassRoomServiceImpl;
import com.netizenbd.springbootApp.service.ClassRoutineServiceImpl;
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
	@Autowired
	private ClassRoutineServiceImpl classRoutineService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/* Sudent */
		Student s1 = new Student("Sekh", "Mahadi");
		service.createStudent(s1);
		Student s2 = new Student("Shekh", "Rupon");
		service.createStudent(s2);
		Student s3 = new Student("Shekh", "Niaz");
		service.createStudent(s3);

		log.info("All Studentss -> {}", service.getAllStudents());
		log.info("Single Student -> {}", service.getStudentById(2));
		/* Class Room */
		ClassRoom cr1 = new ClassRoom("C04", 20, "Available");
		classService.addClassRoom(cr1);
		ClassRoom cr2 = new ClassRoom("C10", 30, "unAvailable");
		classService.addClassRoom(cr2);
		ClassRoom cr3 = new ClassRoom("C09", 25, "Available");
		classService.addClassRoom(cr3);
		ClassRoom cr4 = new ClassRoom("C20", 40, "Available");
		classService.addClassRoom(cr4);
		ClassRoom cr5 = new ClassRoom("C08", 35, "Available");
		classService.addClassRoom(cr5);

		log.info("All Class Room -> {}", classService.getAllClassRoom());
		log.info("All Class Room Find By title and description-> {}",
				classService.findClassroomsByDescriptionIgnoreCase("Available"));

		/* Class Details */
		ClassDetails one = new ClassDetails("One", 30);
		classDetailsService.addClassDetails(one);
		ClassDetails two = new ClassDetails("Two", 20);
		classDetailsService.addClassDetails(two);
		ClassDetails three = new ClassDetails("Three", 34);
		classDetailsService.addClassDetails(three);
		ClassDetails four = new ClassDetails("Four", 25);
		classDetailsService.addClassDetails(four);
		ClassDetails five = new ClassDetails("Five", 40);
		classDetailsService.addClassDetails(five);
		ClassDetails six = new ClassDetails("Six", 30);
		classDetailsService.addClassDetails(six);
		ClassDetails seven = new ClassDetails("seven", 35);
		classDetailsService.addClassDetails(seven);
		log.info("All Class Details -> {}", classDetailsService.getAllClassDetails());

		/* Teacher */
		Teacher t1 = new Teacher("Abdul salam", TeacherType.REGULAR);
		teacherServeice.addTeacher(t1);
		Teacher t2 = new Teacher("Bashar", TeacherType.PARTTIME);
		teacherServeice.addTeacher(t2);

		log.info("All Teachers -> {}", teacherServeice.getAllTeachers());
		log.info("All Teachers by type -> {}", teacherServeice.getAllTeachersByType(TeacherType.PARTTIME));

		/* Course */
		Course phy = new Course("Physics", "PHY");
		courseService.addCourse(phy);
		Course che = new Course("Chemistry", "CHE");
		courseService.addCourse(che);
		Course ban = new Course("Bangla", "BAN");
		courseService.addCourse(ban);
		Course eng = new Course("English", "ENG");
		courseService.addCourse(eng);
		Course mat = new Course("Math", "MAT");
		courseService.addCourse(mat);

		log.info("All Courses -> {}", courseService.getAllCourse());

		/* routine */

		ClassRoutine classRoutine = new ClassRoutine(one);
		classRoutineService.addRoutine(classRoutine);
		classRoutineService.addRoutine(new ClassRoutine(two));
		classRoutineService.addRoutine(new ClassRoutine(three));
		classRoutineService.addRoutine(new ClassRoutine(four));
		log.info("Class Routine -> {}", classRoutineService.getAllRoutines());
	}

}
