package com.netizenbd.springbootApp.dto;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class TutorReportsDTO {
	
	private Long teacherId;
	@NonNull
	private String teacherName;
	@NonNull
	@JsonIgnoreProperties(value = "teacherDTO")
	private List<StudentDTO> students;	
}
