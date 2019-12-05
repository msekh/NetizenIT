package com.netizenbd.springbootApp.entity;

import com.netizenbd.springbootApp.exeption.ResourceNotFoundException;

public enum TeacherType {
	
		REGULAR("Regular"), PARTTIME("Part time");
	private String tType;


	private TeacherType(String tType) {
		this.tType = tType;
	}


	public TeacherType getType(String typeValue) {
		
		for(TeacherType teacherType: values()) {
			if(teacherType.tType.equalsIgnoreCase(typeValue)) {
				return  teacherType;
			}
		}
		throw new ResourceNotFoundException("Teacher not found.", "id", typeValue);
		
	}

}
