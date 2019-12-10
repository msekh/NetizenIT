package com.netizenbd.springbootApp.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TutorReportsDTO {
	private Long teacherId;
	@NonNull
	private String teacherName;
	@NonNull
	private List<Student> students;
}
