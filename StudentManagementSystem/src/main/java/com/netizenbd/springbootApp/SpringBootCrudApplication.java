package com.netizenbd.springbootApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.netizenbd.springbootApp.entity.Student;
import com.netizenbd.springbootApp.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBootCrudApplication implements CommandLineRunner {
	@Autowired
	private StudentService service;

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
	}

}
