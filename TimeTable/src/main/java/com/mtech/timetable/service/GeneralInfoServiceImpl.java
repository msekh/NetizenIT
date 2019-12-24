package com.mtech.timetable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtech.timetable.dto.GeneralInfoDTO;
import com.mtech.timetable.dto_convert.DtoCoverter;
import com.mtech.timetable.entity.GeneralInfo;
import com.mtech.timetable.repository.GeneralInfoRepository;
@Service
public class GeneralInfoServiceImpl {
	
@Autowired
private GeneralInfoRepository generalInfoRepository;
	
	public GeneralInfoDTO	createGeneralInfo(GeneralInfoDTO info) {
		GeneralInfo generalInfo = generalInfoRepository.save(DtoCoverter.toConvertGeneralInfoFromGeneralInfoDTO(info));
		return DtoCoverter.toConvertGeneralInfoDTOFromGeneralInfo(generalInfo);
	}
	
	public List<GeneralInfo> getAllGeneralInfo() {
		return generalInfoRepository.findAll();
	}
	
	public List<GeneralInfo> geTypeInfos(String type_defaultId) {
		
		return generalInfoRepository.findByTypeDefaultId(type_defaultId);	
	}
		
}
