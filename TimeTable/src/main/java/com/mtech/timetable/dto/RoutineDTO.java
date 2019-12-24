package com.mtech.timetable.dto;

import java.time.DayOfWeek;


import com.mtech.timetable.entity.GeneralInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class RoutineDTO {
	
	private Long routineId;
	@NonNull
	private GeneralInfo period;
	@NonNull
	private GeneralInfo teacher;
	@NonNull
	private GeneralInfo clazz;
	@NonNull
	private GeneralInfo subject;
	@NonNull
	private DayOfWeek day;
}
