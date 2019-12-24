package com.mtech.timetable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mtech.timetable.dto.RoutineDTO;
import com.mtech.timetable.service.RoutineServiceImpl;

@RestController
public class RoutineController {
	@Autowired
	private RoutineServiceImpl routineService;

	@PostMapping("/create_routine")
	public ResponseEntity<RoutineDTO> createRoutine(@RequestBody RoutineDTO dto) {
		return ResponseEntity.ok().body(routineService.createRoutine(dto));
	}

	@GetMapping("/get_all_routine")
	public ResponseEntity<List<RoutineDTO>> getAllRoutine() {
		return ResponseEntity.ok().body(routineService.getAllRoutine());
	}

}
