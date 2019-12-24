package com.mtech.timetable.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mtech.timetable.entity.TypeInfo;
import com.mtech.timetable.repository.TypeInfoRepository;

public class TypeInfoService {
	@Autowired
	private TypeInfoRepository typeInfoRepository;

	public TypeInfo addTypeInfo(TypeInfo info) {
		return typeInfoRepository.save(info);
	}
	
	public List<TypeInfo> getAllTypeInfos(){
		return typeInfoRepository.findAll();
	}
}
