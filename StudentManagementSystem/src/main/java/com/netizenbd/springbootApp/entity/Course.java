package com.netizenbd.springbootApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "c_id_sequence")
	@SequenceGenerator(name = "c_id_sequence", sequenceName = "cId_SEQ", initialValue = 101, allocationSize = 50)
	private Integer id;
	@NonNull
	private String courseName;
	@NonNull
	private String courseCode;
	

}
