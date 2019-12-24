package com.mtech.timetable.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtech.timetable.dto.RoutineDTO;
import com.mtech.timetable.dto_convert.DtoCoverter;
import com.mtech.timetable.entity.Routine;
import com.mtech.timetable.repository.RoutineRepository;
@Service
public class RoutineServiceImpl {
	@Autowired
	private RoutineRepository routineRepository;
	
	public RoutineDTO createRoutine(RoutineDTO routineDTO) {
		Routine routine = routineRepository.save(DtoCoverter.toConvertRoutineFromConvertRoutineDTO(routineDTO));
		return DtoCoverter.toConvertRoutineDTOFromRoutine(routine);
	}
	
	
	public List<RoutineDTO> getAllRoutine(){
		
		return routineRepository.findAll()
				.stream()
				.map(DtoCoverter::toConvertRoutineDTOFromRoutine)			
				.collect(Collectors.toList());
	}
}
