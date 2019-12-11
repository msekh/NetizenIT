package com.netizenbd.springbootApp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
	
	private Long id;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private Long rollId;
	@NonNull
	private TeacherDTO teacher;
}
