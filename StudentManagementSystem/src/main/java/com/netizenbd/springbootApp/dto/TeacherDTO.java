package com.netizenbd.springbootApp.dto;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;


import com.netizenbd.springbootApp.entity.TeacherType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO {

	private Long id;
	@NonNull
	private String teacherName;
	@NonNull
	@Enumerated(EnumType.STRING)
	private TeacherType type;
}
