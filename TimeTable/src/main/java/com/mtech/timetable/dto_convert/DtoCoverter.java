package com.mtech.timetable.dto_convert;

import com.mtech.timetable.dto.GeneralInfoDTO;
import com.mtech.timetable.dto.RoutineDTO;
import com.mtech.timetable.entity.GeneralInfo;
import com.mtech.timetable.entity.Routine;

public class DtoCoverter {

	public static GeneralInfoDTO toConvertGeneralInfoDTOFromGeneralInfo(GeneralInfo generalInfo) {

		return new GeneralInfoDTO().setInfoId(generalInfo.getInfoId()).setInfoName(generalInfo.getInfoName())
				.setDefaultId(generalInfo.getDefaultId()).setTypeDefaultId(generalInfo.getTypeDefaultId());
	}

	
	public static GeneralInfo toConvertGeneralInfoFromGeneralInfoDTO(GeneralInfoDTO generalInfoDTO) {

		return new GeneralInfo().setInfoId(generalInfoDTO.getInfoId()).setInfoName(generalInfoDTO.getInfoName())
				.setDefaultId(generalInfoDTO.getDefaultId()).setTypeDefaultId(generalInfoDTO.getTypeDefaultId());
	}
	public static RoutineDTO toConvertRoutineDTOFromRoutine(Routine routine) {

		return RoutineDTO.builder().routineId(routine.getRoutineId()).period(routine.getPeriod())
				.teacher(routine.getTeacher()).clazz(routine.getClazz()).subject(routine.getSubject())
				.day(routine.getDay()).build();
	}

	public static Routine toConvertRoutineFromConvertRoutineDTO(RoutineDTO routineDTO) {
		return Routine.builder().period(routineDTO.getPeriod()).teacher(routineDTO.getTeacher())
				.clazz(routineDTO.getClazz()).subject(routineDTO.getSubject()).day(routineDTO.getDay()).build();
	}
}
