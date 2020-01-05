package com.mtech.timetable;

import java.time.DayOfWeek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mtech.timetable.dto.RoutineDTO;
import com.mtech.timetable.entity.GeneralInfo;
import com.mtech.timetable.repository.GeneralInfoRepository;
import com.mtech.timetable.repository.RoutineRepository;
import com.mtech.timetable.service.RoutineServiceImpl;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class TimeTableApplication implements CommandLineRunner {
	@Autowired
	private GeneralInfoRepository gRepo;
	@Autowired
	private RoutineRepository rRepo;
	@Autowired
	private RoutineServiceImpl rService;

	public static void main(String[] args) {
		SpringApplication.run(TimeTableApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		GeneralInfo period = new GeneralInfo("period 1st", "P101", "T101");
		GeneralInfo teacher = new GeneralInfo("Abul Hasn", "T101", "T102");
		GeneralInfo clazz = new GeneralInfo("Ten", "C101", "T103");
		GeneralInfo subject = new GeneralInfo("bangla", "S101", "T104");
		
		gRepo.save(period);
		gRepo.save(teacher);
		gRepo.save(clazz);
		gRepo.save(subject);
		
		log.info("All General info -> {}", gRepo.findAll());
		
		RoutineDTO routineDTO = RoutineDTO.builder().period(period)
				.teacher(teacher)
				.clazz(clazz)
				.subject(subject)
				.day(DayOfWeek.SATURDAY)
				.build();
		rService.createRoutine(routineDTO);
		
		log.info("All Routine info -> {}", rRepo.findAll());

	}

}
