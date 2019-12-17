package com.netizenbd.springbootApp.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.validator.constraints.UniqueElements;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "t_id_sequence")
	@SequenceGenerator(name = "t_id_sequence", sequenceName = "tId_SEQ", initialValue = 10001, allocationSize = 5)
	@Column(name = "t_id")
	private Long id;
	@NonNull
	private String teacherName;
	@NonNull
	@Enumerated(EnumType.STRING)
	private TeacherType type;
	
	

}
