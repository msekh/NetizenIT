package com.netizenbd.springbootApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.netizenbd.springbootApp.entity.ClassRoom;
import com.netizenbd.springbootApp.entity.Student;
import com.netizenbd.springbootApp.service.ClassRoomService;
import com.netizenbd.springbootApp.service.ClassRoomServiceImpl;
import com.netizenbd.springbootApp.service.StudentService;
import com.netizenbd.springbootApp.service.StudentServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBootCrudApplication implements CommandLineRunner {
	@Autowired
	private StudentServiceImpl service;
	@Autowired
	ClassRoomServiceImpl classService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		service.createStudent(new Student("Sekh", "Mahadi"));
		service.createStudent(new Student("Shekh", "Rupon"));
		service.createStudent(new Student("Shekh", "Niaz"));

		log.info("All Studentss -> {}", service.getAllStudents());
		log.info("Single Student -> {}", service.getStudentById(2));
		
		
		classService.createClassRoom(new ClassRoom("C04", "ClassFour", "Available"));
		classService.createClassRoom(new ClassRoom("C10", "ClassFour", "unAvailable"));
		classService.createClassRoom(new ClassRoom("C09", "Classfive", "Available"));
		classService.createClassRoom(new ClassRoom("C20", "ClassFour", "Available"));
		classService.createClassRoom(new ClassRoom("C08", "ClassSix", "Available"));
		
		log.info("All Class Room -> {}", classService.getAllClassRoom());
		log.info("All Class Room Find By title -> {}", classService.findClassRoomsByTitleContainsIgnoreCase("ClassFour"));
		log.info("All Class Room Find By title and description-> {}",classService.findClassroomsByTitleAndAndDescription("C04", "Unavailable"));
	}

}
